package kr.co.funch.api.interfaces.dto

import org.springframework.http.HttpStatus

data class ApiResponseDto<T>(
    val status: String = HttpStatus.OK.value().toString(),
    val message: String? = HttpStatus.OK.reasonPhrase,
    val data: T? = null,
)
