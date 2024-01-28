package kr.co.funch.api.domain.member.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime

@Document(collection = "Member")
data class Member(
    @Id
    val id: ObjectId? = null,
    val name: String,
    val birthDate: LocalDate,
    val age: Int,
    val constellation: Constellation,
    val jobGroup: JobGroup,
    val clubs: List<Club>,
    val subwayStations: List<SubwayStation>,
    val mbti: Mbti,
    val viewCount: Int = 0,
    @Indexed(unique = true)
    val deviceNumber: String,
    val memberCode: String? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
