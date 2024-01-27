package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.Member
import kr.co.funch.api.domain.member.model.SubwayStation

data class MemberMatching(
    val targetMember: Member,
    val mbtiChemistry: MbtiChemistry,
    val constellationChemistry: ConstellationChemistry,
    val jobMatching: Boolean,
    val matchingClubInfo: List<Club>,
    val matchingSubwayInfo: List<SubwayStation>,
) {
    private var totalItem: Int = 0
    private var matchedItem: Int = 0

    fun getChemistryInfos(): List<ChemistryInfo> {
        return listOf(
            mbtiChemistry.chemistryInfo,
            constellationChemistry.chemistryInfo,
        )
    }

    fun calculateSimilarity(): Int {
        countMatchedItemIf(mbtiChemistry.isEqualMbti())
        countMatchedItemIf(constellationChemistry.isEqualConstellation())
        countMatchedItemIf(jobMatching)
        countMatchedItemIf(matchingClubInfo.isNotEmpty())
        countMatchedItemIf(matchingSubwayInfo.isNotEmpty())
        return matchedItem * 100 / totalItem
    }

    private fun countMatchedItemIf(condition: Boolean) {
        totalItem += 1
        if (condition) {
            matchedItem += 1
        }
    }
}
