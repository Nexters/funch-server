package kr.co.funch.api.domain.member.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class SubwayStation(
    @Id
    val id: String,
    val lines: List<SubwayLine>,
    val location: Location,
) {
    data class Location(
        val latitude: Double,
        val longitude: Double,
    )

    enum class SubwayLine {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        AIRPORT,
        BUNDANG,
        EVERLINE,
        GYEONGCHUN,
        GYEONGUI,
        SINBUNDANG,
        SUIN,
    }
}
