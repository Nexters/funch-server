package kr.co.funch.api.interfaces

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
    @PostMapping
    fun match(
        @RequestBody matchingDto: MemberMatchingDto.MatchingRequestDto,
    ): ApiResponseDto<MemberMatchingDto.MatchingResponseDto> {
        return ApiResponseDto(
            status = HttpStatus.OK.value().toString(),
            message = HttpStatus.OK.reasonPhrase,
            data = null,
        )
    }
}
