package kr.co.funch.api.interfaces

import kr.co.funch.api.interfaces.dto.ApiResponseDto
import kr.co.funch.api.interfaces.dto.MatchingDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/matching")
class MatchingController {

    @PostMapping
    fun match(@RequestBody matchingDto: MatchingDto.MatchingRequestDto
    ): ApiResponseDto<MatchingDto.MatchingResponseDto> {


        return ApiResponseDto(
            status = HttpStatus.OK.value().toString(),
            message = HttpStatus.OK.reasonPhrase,
            data = null
        )
    }
}
