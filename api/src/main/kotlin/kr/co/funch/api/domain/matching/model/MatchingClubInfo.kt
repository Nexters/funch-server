package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Club

data class MatchingClubInfo(
    val clubs: List<Club>,
) {
    companion object {
        fun of(
            clubs: List<Club>,
            targetClubs: List<Club>,
        ): MatchingClubInfo {
            val matchingClubs = mutableListOf<Club>()
            for (club in clubs) {
                for (targetClub in targetClubs) {
                    if (club == targetClub) {
                        matchingClubs.add(targetClub)
                    }
                }
            }
            return MatchingClubInfo(matchingClubs)
        }
    }

    fun hasMatchingClub(): Boolean {
        return clubs.isNotEmpty()
    }
}
