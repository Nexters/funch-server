package kr.co.funch.api.domain.matching.model

data class MemberMatching(
    val mbtiChemistry: MbtiChemistry,
    val constellationChemistry: ConstellationChemistry,
    val jobMatching: Boolean,
    val clubMatching: Boolean,
    val subwayMatchingInfo: SubwayMatchingInfo
) {
    private var totalItem: Double = 0.0
    private var matchedItem: Double = 0.0

    fun getMatchingRatio() {
        addMatchedItemIf(mbtiChemistry.isEqualMbti())
        addMatchedItemIf(constellationChemistry.isEqualConstellation())
        addMatchedItemIf(jobMatching)
        addMatchedItemIf(clubMatching)
        addMatchedItemIf(subwayMatchingInfo.isEqualLine())
    }

    private fun addMatchedItemIf(condition: Boolean) {
        totalItem += 1.0
        if (condition) {
            matchedItem += 1.0
        }
    }
}
