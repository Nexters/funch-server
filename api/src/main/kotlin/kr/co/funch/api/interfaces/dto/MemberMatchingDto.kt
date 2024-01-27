package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.Member

object MemberMatchingDto {
    data class MatchingRequestDto(
        val requestMemberId: String,
        val targetMemberCode: String,
    )

    data class MatchingResponseDto(
        val profile: TargetProfileDto,
        val similarity: Int,
        val chemistryInfos: List<ChemistryInfo>,
        val recommendInfos: List<RecommendInfo>,
        val subwayInfos: List<SubwayInfo>,
    ) {
        data class TargetProfileDto(
            val name: String,
            val jobGroup: String,
            val clubs: List<Club>,
            val mbti: String,
            val constellation: String,
            val subwayName: List<String>,
        ) {
            companion object {
                fun from(member: Member): TargetProfileDto {
                    return TargetProfileDto(
                        name = member.name,
                        jobGroup = member.jobGroup.koreanName,
                        clubs = member.clubs,
                        mbti = member.mbti.name,
                        constellation = member.constellation.koreanName,
                        subwayName = member.subwayStations.map { it.name }.toList(),
                    )
                }
            }
        }

        data class ChemistryInfo(
            val title: String,
            val description: String,
        )

        data class RecommendInfo(
            val title: String,
        )

        data class SubwayInfo(
            val name: String,
            val lines: List<String>,
        )
    }
}
