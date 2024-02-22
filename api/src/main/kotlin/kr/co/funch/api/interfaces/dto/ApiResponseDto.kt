package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.interfaces.ApiResponseCode
import org.springframework.http.HttpStatus

data class ApiResponseDto<T>(
    val status: String = HttpStatus.OK.value().toString(),
    val message: String? = HttpStatus.OK.reasonPhrase,
    val code: ApiResponseCode = ApiResponseCode.SUCCESS,
    val data: T? = null,
)
