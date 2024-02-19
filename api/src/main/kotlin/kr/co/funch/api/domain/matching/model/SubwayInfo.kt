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
                    subwayStation.lines
                        .map { it.name } // 나중에 한글이름으로 바꿀 예정
                        .toList(),
            )
        }
    }
}
