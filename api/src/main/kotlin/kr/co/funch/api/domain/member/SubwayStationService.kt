package kr.co.funch.api.domain.member

import kr.co.funch.api.domain.member.model.SubwayStation
import org.springframework.stereotype.Service

@Service
class SubwayStationService(
    private val subwayStationRepository: SubwayStationRepository,
) {
    suspend fun subwayStationsByName(name: String): List<SubwayStation> {
        return subwayStationRepository.search(name)
    }
}
