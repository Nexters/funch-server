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

    fun getRecommendInfos(): List<RecommendInfo> {
        val recommendInfos = mutableListOf<RecommendInfo>()
        if (mbtiChemistry.isEqualMbti()) {
            recommendInfos.add(RecommendInfo(targetMember.mbti.name))
        }
        if (constellationChemistry.isEqualConstellation()) {
            recommendInfos.add(RecommendInfo(targetMember.constellation.koreanName))
        }
        if (jobMatching) {
            recommendInfos.add(RecommendInfo(targetMember.jobGroup.koreanName))
        }
        matchingClubInfo
            .forEach { recommendInfos.add(RecommendInfo(it.name)) }
        matchingSubwayInfo
            .forEach { recommendInfos.add(RecommendInfo(it.name)) }

        return recommendInfos.toList()
    }

    fun getSubwayInfos(): List<SubwayInfo> {
        return targetMember.subwayStations
            .map { SubwayInfo.of(it) }
            .toList()
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
