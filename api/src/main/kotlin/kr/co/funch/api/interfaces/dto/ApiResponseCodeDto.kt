package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.interfaces.ApiResponseCode
import org.springframework.http.HttpStatus

// TODO: 클라이언트쪽 코드에 code 반영 이후 ApiResponseDto로 통합
data class ApiResponseCodeDto<T>(
    val status: String = HttpStatus.OK.value().toString(),
    val message: String? = HttpStatus.OK.reasonPhrase,
    val code: ApiResponseCode = ApiResponseCode.SUCCESS,
    val data: T? = null,
)
