package kr.co.funch.api.interfaces

import com.fasterxml.jackson.annotation.JsonValue

enum class ApiResponseCode(
    @get:JsonValue
    val code: String,
    val description: String,
) {
    SUCCESS("1000", "성공"),
    INVALID_INPUT("2000", "입력값 오류"),
    UNAUTHORIZED("3000", "인증 오류"),
    FAIL("4000", "실패"),
    MATCHING_PROFILE_NOT_EXIST("4001", "매칭상대 프로필 존재하지 않음"),
    INTERNAL_ERROR("5000", "서버 오류"),
    ;
}
