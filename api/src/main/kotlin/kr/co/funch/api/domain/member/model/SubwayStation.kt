package kr.co.funch.api.domain.member.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "SubwayStation")
data class SubwayStation(
    @Id
    val id: ObjectId? = null,
    val name: String,
    val lines: List<String>,
    val location: Location = Location(0.0, 0.0),
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
        SEOHAE,
        AIRPORT,
        GIMPO,
        UI_SINSEOL,
        SILLIM,
        YOUNGIN,
        UIJEONGBU,
        BUNDANG,
        GYEONGCHUN,
        GYEONGUI,
        GYEONGGANG,
        INCHEON,
        INCHEON_TWO,
        SINBUNDANG,
    }
}
