package kr.co.funch.api.interfaces

import io.swagger.v3.oas.annotations.Operation
import kr.co.funch.api.domain.member.MemberService
import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.SubwayStation
import kr.co.funch.api.interfaces.dto.ApiResponseDto
import kr.co.funch.api.interfaces.dto.MemberDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val memberService: MemberService,
) {
    @Operation(summary = "Id로 멤버 조회")
    @GetMapping("/{id}")
    suspend fun getMember(
        @PathVariable id: String,
    ): ApiResponseDto<MemberDto.MemberResponse> {
        val member = memberService.findMember(id)

        return ApiResponseDto(
            status = "200",
            message = "OK",
            data = MemberDto.MemberResponse.of(member),
        )
    }

    @Operation(summary = "Device Number로 멤버 조회")
    @GetMapping
    suspend fun getMemberByDeviceNumber(
        @RequestParam deviceNumber: String,
    ): ApiResponseDto<MemberDto.MemberResponse> {
        val member = memberService.findMemberByDeviceNumber(deviceNumber)

        return ApiResponseDto(
            status = "200",
            message = "OK",
            data = MemberDto.MemberResponse.of(member),
        )
    }

    @Operation(summary = "멤버 생성")
    @PostMapping
    suspend fun createMember(
        @RequestBody memberRequest: MemberDto.MemberCreateRequest,
    ): ApiResponseDto<MemberDto.MemberResponse> {
        val member =
            memberService.createMember(
                member = memberRequest.toDomain(),
                subwayStationIds = memberRequest.subwayStations,
            )

        return ApiResponseDto(
            status = "201",
            message = "CREATED",
            data = MemberDto.MemberResponse.of(member),
        )
    }

    @Operation(summary = "멤버 생성")
    @PostMapping("test")
    suspend fun createMember(

    ): ApiResponseDto<MemberDto.MemberResponse> {
        val memberRequest = MemberDto.MemberCreateRequest(
            name = "함석호",
            birthDate = LocalDate.of(1995, 1, 4),
            age = 15,
            jobGroup = "BACKEND",
            clubs = listOf("NEXTERS", "SOPT", "SOMA"),
            subwayStations = listOf("노원역"),
            mbti = "ISTJ",
            deviceNumber = "1234445"
        )
        val member =
            memberService.createMember(
                member = memberRequest.toDomain(),
                subwayStationIds = memberRequest.subwayStations,
            )

        return ApiResponseDto(
            status = "201",
            message = "CREATED",
            data = MemberDto.MemberResponse.of(member),
        )
    }
}
