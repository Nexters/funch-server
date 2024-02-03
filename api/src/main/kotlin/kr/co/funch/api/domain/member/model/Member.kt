package kr.co.funch.api.domain.member.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "Member")
data class Member(
    @Id
    val id: ObjectId? = null,
    val name: String,
    val jobGroup: JobGroup,
    val clubs: List<Club>,
    val subwayStations: List<SubwayStation>,
    val mbti: Mbti,
    val viewCount: Int = 0,
    @Indexed(unique = true)
    val deviceNumber: String,
    val code: String? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
    fun getMatchedClubs(member: Member): List<Club> {
        val referenceClubs = this.clubs.toSet()
        val targetClubs = member.clubs.toSet()
        return referenceClubs.intersect(targetClubs).toList()
    }

    fun getMatchedSubwayStations(member: Member): List<SubwayStation> {
        val referenceSubwayStations = this.subwayStations.toSet()
        val targetSubwayStations = member.subwayStations.toSet()
        return referenceSubwayStations.intersect(targetSubwayStations).toList()
    }

    fun hasSameJobGroup(member: Member): Boolean {
        return jobGroup == member.jobGroup
    }

    fun isSameMember(member: Member): Boolean {
        return id == member.id
    }
}
