package kr.co.funch.api.interfaces

import kr.co.funch.api.domain.member.MemberService
import kr.co.funch.api.interfaces.dto.ApiResponse
import kr.co.funch.api.interfaces.dto.MemberResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService,
) {
    @GetMapping("/member/{id}")
    suspend fun getMember(
        @PathVariable id: String,
    ): ApiResponse<MemberResponse> {
        val member = memberService.findMember(id)

        return ApiResponse(
            status = "200",
            message = "OK",
            data = MemberResponse.of(member),
        )
    }
}
