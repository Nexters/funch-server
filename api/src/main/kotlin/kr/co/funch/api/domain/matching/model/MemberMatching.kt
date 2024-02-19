package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.Member
import kr.co.funch.api.domain.member.model.SubwayStation

data class MemberMatching(
    val targetMember: Member,
    val mbtiChemistry: MbtiChemistry,
    val bloodTypeChemistry: BloodTypeChemistry,
    val jobMatching: Boolean,
    val matchingClubInfo: List<Club>,
    val matchingSubwayInfo: List<SubwayStation>,
    val matchedSubwayLines: SubwayStation.SubwayLine?,
) {
    private var totalItem: Int = 0
    private var matchedItem: Int = 0

    fun getChemistryInfos(): List<ChemistryInfo> {
        return listOf(
            mbtiChemistry.chemistryInfo,
            bloodTypeChemistry.chemistryInfo,
        )
    }

    fun getMatchedInfos(): List<MatchedInfo> {
        val matchedInfos = mutableListOf<MatchedInfo>()
        if (mbtiChemistry.isEqualMbti()) {
            matchedInfos.add(MatchedInfo(targetMember.mbti.name))
        }
        if (bloodTypeChemistry.isEqualBloodType()) {
            matchedInfos.add(MatchedInfo("${targetMember.bloodType.name}형"))
        }
        if (jobMatching) {
            matchedInfos.add(MatchedInfo(targetMember.jobGroup.koreanName))
        }
        matchingClubInfo
            .forEach { matchedInfos.add(MatchedInfo(it.name)) }
        matchingSubwayInfo
            .forEach { matchedInfos.add(MatchedInfo(it.name)) }

        return matchedInfos.toList()
    }

    fun getSubwayInfos(): List<SubwayInfo> {
        return targetMember.subwayStations
            .map { SubwayInfo.of(it) }
            .toList()
    }

    fun calculateSimilarity(): Int {
        countMatchedItemIf(mbtiChemistry.isEqualMbti())
        countMatchedItemIf(bloodTypeChemistry.isEqualBloodType())
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

    fun getSubwayChemistryInfo(): ChemistryInfo? {
        if (matchedSubwayLines == null) {
            return null
        }

        return ChemistryInfo(
            title = matchedSubwayLines.name,
            description = matchedSubwayLines.description,
        )
    }
}
