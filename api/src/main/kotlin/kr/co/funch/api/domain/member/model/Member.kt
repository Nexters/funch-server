package kr.co.funch.api.domain.member.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
data class Member(
    @Id
    val id: String,
    val name: String,
    val birth: LocalDate,
    val age: Int,
    val constellation: Constellation,
    val jobGroup: String,
    val clubs: List<String>,
    val subwayStations: List<SubwayStation>,
    val mbti: Mbti,
    val viewCount: Int = 0,
    val deviceNumber: String,
)
