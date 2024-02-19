package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.domain.member.model.BloodType
import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.JobGroup
import kr.co.funch.api.domain.member.model.Mbti
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import java.time.LocalDateTime

object MemberDto {
    data class MemberResponse(
        val id: String,
        val name: String,
        val bloodType: BloodType,
        val jobGroup: String,
        val clubs: List<Club>,
        val subwayInfos: List<SubwayInfo>,
        val mbti: Mbti,
        val memberCode: String,
        val viewCount: Int,
    ) {
        data class SubwayInfo(
            val name: String,
            val lines: List<String>,
        )

        companion object {
            fun of(member: Member): MemberResponse {
                return MemberResponse(
                    id = member.id.toString(),
                    name = member.name,
                    bloodType = member.bloodType,
                    jobGroup = member.jobGroup.koreanName,
                    clubs = member.clubs,
                    subwayInfos =
                        member.subwayStations.map { station ->
                            SubwayInfo(station.name, station.lines.map { it.name })
                        },
                    mbti = member.mbti,
                    memberCode = member.code.orEmpty(),
                    viewCount = member.viewCount,
                )
            }
        }
    }

    data class MemberCreateRequest(
        val name: String,
        val jobGroup: JobGroup,
        val clubs: List<Club>,
        val bloodType: BloodType,
        val subwayStations: List<String>,
        val mbti: Mbti,
        val deviceNumber: String,
    ) {
        fun toDomain(): Member {
            return Member(
                id = ObjectId(),
                name = name,
                bloodType = bloodType,
                jobGroup = jobGroup,
                clubs = clubs,
                subwayStations = emptyList(),
                mbti = mbti,
                deviceNumber = deviceNumber,
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now(),
            )
        }
    }
}
