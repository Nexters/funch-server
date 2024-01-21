package kr.co.funch.api.interfaces.dto

data class ApiResponseDto<T>(
    val status: String,
    val message: String?,
    val data: T?,
)
