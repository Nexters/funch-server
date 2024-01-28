package kr.co.funch.api.interfaces

import io.swagger.v3.oas.annotations.Operation
import kr.co.funch.api.domain.matching.MemberMatchingService
import kr.co.funch.api.interfaces.dto.ApiResponseDto
import kr.co.funch.api.interfaces.dto.MemberMatchingDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/matching")
class MemberMatchingController(
    private val memberMatchingService: MemberMatchingService,
) {
    @Operation(summary = "프로필 매칭")
    @PostMapping
    suspend fun match(
        @RequestBody matchingDto: MemberMatchingDto.MatchingRequestDto,
    ): ApiResponseDto<MemberMatchingDto.MatchingResponseDto> {
        val memberMatching =
            memberMatchingService.getMatchingInfo(
                matchingDto.requestMemberId,
                matchingDto.targetMemberCode,
            )

        return ApiResponseDto(
            status = HttpStatus.OK.value().toString(),
            message = HttpStatus.OK.reasonPhrase,
            data =
                MemberMatchingDto.MatchingResponseDto(
                    profile = MemberMatchingDto.MatchingResponseDto.TargetProfile.from(memberMatching.targetMember),
                    similarity = memberMatching.calculateSimilarity(),
                    chemistryInfos = memberMatching.getChemistryInfos(),
                    recommendInfos = memberMatching.getRecommendInfos(),
                    subwayInfos = memberMatching.getSubwayInfos(),
                ),
        )
    }
}
