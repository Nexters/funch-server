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

    fun getMatchingRatio(): Int {
        addMatchedItemIf(mbtiChemistry.isEqualMbti())
        addMatchedItemIf(constellationChemistry.isEqualConstellation())
        addMatchedItemIf(jobMatching)
        addMatchedItemIf(matchingClubInfo.isNotEmpty())
        addMatchedItemIf(matchingSubwayInfo.isNotEmpty())
        return matchedItem * 100 / totalItem
    }

    private fun countMatchedItemIf(condition: Boolean) {
        totalItem += 1
        if (condition) {
            matchedItem += 1
        }
    }
}
