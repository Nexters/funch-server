package kr.co.funch.api.interfaces.dto

object MemberMatchingDto {
    data class MatchingRequestDto(
        val requestMemberId: String,
        val targetMemberCode: String,
    )

    // TODO: 응답 포맷 변경 필요
    data class MatchingResponseDto(
        val items: List<String>,
        val ratio: Double,
    )
}
