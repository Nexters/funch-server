package kr.co.funch.api.domain.matching.model

data class MemberMatching(
    val mbtiChemistry: MbtiChemistry,
    val constellationChemistry: ConstellationChemistry,
    val jobMatching: Boolean,
    val matchingClubInfo: MatchingClubInfo,
    val subwayMatchingInfo: SubwayMatchingInfo,
) {
    private var totalItem: Double = 0.0
    private var matchedItem: Double = 0.0

    fun getMatchingRatio(): Double {
        addMatchedItemIf(mbtiChemistry.isEqualMbti())
        addMatchedItemIf(constellationChemistry.isEqualConstellation())
        addMatchedItemIf(jobMatching)
        addMatchedItemIf(matchingClubInfo.hasMatchingClub())
        addMatchedItemIf(subwayMatchingInfo.isEqualLine())
        return matchedItem / totalItem
    }

    private fun addMatchedItemIf(condition: Boolean) {
        totalItem += 1.0
        if (condition) {
            matchedItem += 1.0
        }
    }
}
