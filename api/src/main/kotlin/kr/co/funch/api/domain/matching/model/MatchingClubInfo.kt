package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Club

data class MatchingClubInfo(
    val clubs: List<Club>,
) {
    fun hasMatchingClub(): Boolean {
        return clubs.isNotEmpty()
    }
}
