package kr.co.funch.api.domain.member

import kr.co.funch.api.domain.member.model.SubwayStation
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class SubwayStationService(
    private val subwayStationRepository: SubwayStationRepository,
) {
    suspend fun subwayStationsByName(name: String): List<SubwayStation> {
        // return subwayStationRepository.search(name)

        // 임시로 mock 데이터를 반환합니다.
        return mockSubwayStationMap
            .filterKeys { it.contains(name) }
            .values
            .toList()
            .take(5)
    }

    val mockSubwayStationMap =
        mapOf(
            "강남역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "강남역",
                    lines = listOf(SubwayStation.SubwayLine.TWO),
                    location =
                        SubwayStation.Location(
                            latitude = 37.497942,
                            longitude = 127.027621,
                        ),
                ),
            "역삼역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "역삼역",
                    lines = listOf(SubwayStation.SubwayLine.TWO),
                    location =
                        SubwayStation.Location(
                            latitude = 37.500622,
                            longitude = 127.036570,
                        ),
                ),
            "삼성역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "삼성역",
                    lines = listOf(SubwayStation.SubwayLine.TWO),
                    location =
                        SubwayStation.Location(
                            latitude = 37.508725,
                            longitude = 127.063196,
                        ),
                ),
            "선릉역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "선릉역",
                    lines = listOf(SubwayStation.SubwayLine.TWO),
                    location =
                        SubwayStation.Location(
                            latitude = 37.504503,
                            longitude = 127.049008,
                        ),
                ),
            "삼성중앙역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "삼성중앙역",
                    lines = listOf(SubwayStation.SubwayLine.SEVEN),
                    location =
                        SubwayStation.Location(
                            latitude = 37.512939,
                            longitude = 127.053350,
                        ),
                ),
            "봉은사역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "봉은사역",
                    lines = listOf(SubwayStation.SubwayLine.NINE),
                    location =
                        SubwayStation.Location(
                            latitude = 37.514219,
                            longitude = 127.060245,
                        ),
                ),
            "종합운동장역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "종합운동장역",
                    lines = listOf(SubwayStation.SubwayLine.NINE),
                    location =
                        SubwayStation.Location(
                            latitude = 37.510997,
                            longitude = 127.073642,
                        ),
                ),
            "삼전역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "삼전역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.504067,
                            longitude = 127.087368,
                        ),
                ),
            "석촌역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "석촌역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.505431,
                            longitude = 127.106963,
                        ),
                ),
            "송파역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "송파역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.499703,
                            longitude = 127.112183,
                        ),
                ),
            "가락시장역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "가락시장역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.492522,
                            longitude = 127.118234,
                        ),
                ),
            "문정역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "문정역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.485855,
                            longitude = 127.121042,
                        ),
                ),
            "장지역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "장지역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.478703,
                            longitude = 127.126191,
                        ),
                ),
            "복정역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "복정역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.470047,
                            longitude = 127.126662,
                        ),
                ),
            "산성역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "산성역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.457122,
                            longitude = 127.139310,
                        ),
                ),
            "남한산성입구역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "남한산성입구역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.451535,
                            longitude = 127.159433,
                        ),
                ),
            "단대오거리역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "단대오거리역",
                    lines = listOf(SubwayStation.SubwayLine.ONE),
                    location =
                        SubwayStation.Location(
                            latitude = 37.445680,
                            longitude = 127.156877,
                        ),
                ),
            "신흥역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "신흥역",
                    lines = listOf(SubwayStation.SubwayLine.ONE),
                    location =
                        SubwayStation.Location(
                            latitude = 37.440029,
                            longitude = 127.147361,
                        ),
                ),
            "수진역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "수진역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.437428,
                            longitude = 127.140722,
                        ),
                ),
            "모란역" to
                SubwayStation(
                    id = ObjectId(),
                    name = "모란역",
                    lines = listOf(SubwayStation.SubwayLine.EIGHT),
                    location =
                        SubwayStation.Location(
                            latitude = 37.432130,
                            longitude = 127.129087,
                        ),
                ),
        )
}
