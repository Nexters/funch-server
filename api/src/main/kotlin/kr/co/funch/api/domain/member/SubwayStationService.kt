package kr.co.funch.api.domain.member

import kr.co.funch.api.domain.member.model.SubwayStation
import org.springframework.stereotype.Service

@Service
class SubwayStationService(
    private val subwayStationRepository: SubwayStationRepository,
) {
    suspend fun findSubwayStationsNameContains(query: String): List<SubwayStation> {
        val name =
            if (query !in STATION_NAME_POSTFIX_TRIM_EXCEPTION_LIST && query.endsWith(STATION_NAME_POSTFIX)) {
                query.substring(0, query.length - 1)
            } else {
                query
            }
        return subwayStationRepository.searchNameContains(name)
    }

    suspend fun findSubwayStationsByNames(subwayStationNames: List<String>): List<SubwayStation> {
        return subwayStationRepository.searchByNames(subwayStationNames)
    }

    companion object {
        const val STATION_NAME_POSTFIX = "역"
        val STATION_NAME_POSTFIX_TRIM_EXCEPTION_LIST =
            setOf(
                "서울역",
            )
    }
}
