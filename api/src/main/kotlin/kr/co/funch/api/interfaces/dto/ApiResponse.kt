package kr.co.funch.api.interfaces.dto

data class ApiResponse<T>(
    val status: String,
    val message: String?,
    val data: T?,
)
