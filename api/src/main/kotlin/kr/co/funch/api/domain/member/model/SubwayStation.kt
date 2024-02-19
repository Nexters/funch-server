package kr.co.funch.api.domain.member.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "SubwayStation")
data class SubwayStation(
    @Id
    val id: ObjectId? = null,
    val name: String,
    val lines: Set<SubwayLine>,
    val location: Location = Location(0.0, 0.0),
) {
    data class Location(
        val latitude: Double,
        val longitude: Double,
    )

    enum class SubwayLine(val description: String) {
        ONE("1호선"),
        TWO("2호선"),
        THREE("3호선"),
        FOUR("4호선"),
        FIVE("5호선"),
        SIX("6호선"),
        SEVEN("7호선"),
        EIGHT("8호선"),
        NINE("9호선"),
        SEOHAE("서해선"),
        AIRPORT("공항철도"),
        GIMPO("김포골드"),
        UI_SINSEOL("우이신설"),
        SILLIM("신림선"),
        YOUNGIN("에버라인"),
        UIJEONGBU("의정부선"),
        BUNDANG("수인분당선"),
        GYEONGCHUN("경춘선"),
        GYEONGUI("경의중앙선"),
        GYEONGGANG("경강선"),
        INCHEON("인천1호선"),
        INCHEON_TWO("인천2호선"),
        SINBUNDANG("신분당선"),
    }
}
