package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.domain.member.model.SubwayStation

object SubwayStationDto {
    data class SubwayStationResponse(
        val id: String,
        val name: String,
        val lines: List<SubwayStation.SubwayLine>,
        val location: Location,
    ) {
        data class Location(
            val latitude: String,
            val longitude: String,
        )

        companion object {
            fun of(subwayStation: SubwayStation): SubwayStationResponse {
                return SubwayStationResponse(
                    id = subwayStation.id.toString(),
                    name = subwayStation.name,
                    lines = subwayStation.lines.map { SubwayStation.SubwayLine.valueOf(it) },
                    location =
                        Location(
                            latitude = subwayStation.location.latitude.toString(),
                            longitude = subwayStation.location.longitude.toString(),
                        ),
                )
            }
        }
    }
}
