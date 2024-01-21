package kr.co.funch.api.interfaces

import kr.co.funch.api.domain.member.MemberService
import kr.co.funch.api.interfaces.dto.ApiResponse
import kr.co.funch.api.interfaces.dto.MemberDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val memberService: MemberService,
) {
    @GetMapping("/{id}")
    suspend fun getMember(
        @PathVariable id: String,
    ): ApiResponse<MemberDto.MemberResponse> {
        val member = memberService.findMember(id)

        return ApiResponse(
            status = "200",
            message = "OK",
            data = MemberDto.MemberResponse.of(member),
        )
    }

    @PostMapping
    suspend fun createMember(
        @RequestBody memberRequest: MemberDto.MemberCreateRequest,
    ): ApiResponse<MemberDto.MemberResponse> {
        val member = memberService.createMember(
            member = memberRequest.toDomain(),
            subwayStationIds = memberRequest.subwayStations
        )

        return ApiResponse(
            status = "201",
            message = "CREATED",
            data = MemberDto.MemberResponse.of(member),
        )
    }
}
