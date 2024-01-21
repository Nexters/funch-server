package kr.co.funch.api.interfaces.dto

object MemberMatchingDto {
    data class MatchingRequestDto(
        val requestMemberId: String,
        val targetMemberCode: String,
    )

    data class MatchingResponseDto(
        val items: List<String>,
        val ratio: Double,
    )
}
