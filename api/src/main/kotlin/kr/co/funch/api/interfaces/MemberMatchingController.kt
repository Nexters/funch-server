package kr.co.funch.api.interfaces

import io.swagger.v3.oas.annotations.Operation
import kr.co.funch.api.domain.matching.MatchingRecordService
import kr.co.funch.api.domain.matching.MemberMatchingService
import kr.co.funch.api.interfaces.dto.ApiResponseCodeDto
import kr.co.funch.api.interfaces.dto.ApiResponseDto
import kr.co.funch.api.interfaces.dto.MemberMatchingDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/matching")
class MemberMatchingController(
    private val memberMatchingService: MemberMatchingService,
    private val matchingRecordService: MatchingRecordService,
) {
    @Operation(summary = "프로필 매칭")
    @PostMapping
    suspend fun match(
        @RequestBody matchingDto: MemberMatchingDto.MatchingRequestDto,
    ): ApiResponseDto<MemberMatchingDto.MatchingResponseDto> {
        val memberMatching =
            memberMatchingService.getMatchingInfo(
                matchingDto.requestMemberId,
                matchingDto.targetMemberCode.uppercase(),
            )

        matchingRecordService.upsertMatchingRecord(matchingDto, memberMatching)

        return ApiResponseDto(
            status = HttpStatus.OK.value().toString(),
            message = HttpStatus.OK.reasonPhrase,
            data =
                MemberMatchingDto.MatchingResponseDto(
                    profile = MemberMatchingDto.MatchingResponseDto.TargetProfile.from(memberMatching.targetMember),
                    similarity = memberMatching.calculateSimilarity(),
                    chemistryInfos = memberMatching.getChemistryInfos(),
                    matchedInfos = memberMatching.getMatchedInfos(),
                    subwayChemistryInfo = memberMatching.getSubwayChemistryInfo(),
                ),
        )
    }

    @Operation(summary = "매칭 기록 조회")
    @GetMapping("/{requestMemberId}/records")
    suspend fun records(
        @PathVariable requestMemberId: String?,
    ): ApiResponseDto<List<MemberMatchingDto.MatchingRecordResponseDto>> {
        if (requestMemberId.isNullOrBlank()) {
            return ApiResponseDto(
                status = HttpStatus.BAD_REQUEST.value().toString(),
                message = "requestMemberId is required",
                data = null,
            )
        }

        val matchingRecords = matchingRecordService.getMatchingRecords(requestMemberId)

        return ApiResponseDto(
            status = HttpStatus.OK.value().toString(),
            message = HttpStatus.OK.reasonPhrase,
            data =
                matchingRecords.map {
                    MemberMatchingDto.MatchingRecordResponseDto(
                        requestMemberId = it.requestMemberId,
                        targetMemberCode = it.targetMemberCode,
                        memberMatching = it.memberMatching,
                        createdAt = it.createdAt.toString(),
                        updatedAt = it.updatedAt.toString(),
                    )
                },
        )
    }

    @Operation(summary = "프로필 매칭 가능 여부 조회")
    @GetMapping("/{targetMemberCode}")
    suspend fun isPossible(
        @PathVariable targetMemberCode: String,
    ): ApiResponseCodeDto<Unit> {
        val canMatching = memberMatchingService.canMatching(targetMemberCode)

        // TODO: GlobalExceptionHandler에 위임
        if (canMatching) {
            return ApiResponseCodeDto()
        }

        return ApiResponseCodeDto(
            code = ApiResponseCode.MATCHING_PROFILE_NOT_EXIST,
            message = ApiResponseCode.MATCHING_PROFILE_NOT_EXIST.message,
        )
    }
}
