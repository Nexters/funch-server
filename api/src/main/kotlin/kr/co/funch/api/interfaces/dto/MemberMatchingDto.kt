package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.domain.matching.model.ChemistryInfo
import kr.co.funch.api.domain.matching.model.MatchedInfo
import kr.co.funch.api.domain.matching.model.MemberMatching
import kr.co.funch.api.domain.matching.model.SubwayInfo
import kr.co.funch.api.domain.member.model.BloodType
import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.Mbti
import kr.co.funch.api.domain.member.model.Member

object MemberMatchingDto {
    data class MatchingRequestDto(
        val requestMemberId: String,
        val targetMemberCode: String,
    )

    data class MatchingResponseDto(
        val profile: TargetProfile,
        val similarity: Int,
        val chemistryInfos: List<ChemistryInfo>,
        val matchedInfos: List<MatchedInfo>,
        val subwayChemistryInfo: ChemistryInfo?,
    ) {
        data class TargetProfile(
            val name: String,
            val jobGroup: String,
            val clubs: List<Club>,
            val mbti: Mbti,
            val bloodType: BloodType,
            val subwayInfos: List<SubwayInfo>,
        ) {
            companion object {
                fun from(member: Member): TargetProfile {
                    return TargetProfile(
                        name = member.name,
                        jobGroup = member.jobGroup.koreanName,
                        clubs = member.clubs,
                        mbti = member.mbti,
                        bloodType = member.bloodType,
                        subwayInfos =
                            member.subwayStations
                                .map { SubwayInfo.of(it) }
                                .toList(),
                    )
                }
            }
        }
    }

    data class MatchingRecordResponseDto(
        val requestMemberId: String,
        val targetMemberCode: String,
        val memberMatching: MemberMatching,
        val createdAt: String,
        val updatedAt: String,
    )
}
