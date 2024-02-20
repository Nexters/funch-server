package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.SubwayStation

data class SubwayInfo(
    val name: String,
    val lines: List<String>,
) {
    companion object {
        fun of(subwayStation: SubwayStation): SubwayInfo {
            return SubwayInfo(
                name = subwayStation.name,
                lines =
                    subwayStation.lines.toList(),
            )
        }
    }
}
