package kr.co.funch.api.interfaces

import io.swagger.v3.oas.annotations.Operation
import kr.co.funch.api.domain.member.SubwayStationService
import kr.co.funch.api.interfaces.dto.ApiResponseDto
import kr.co.funch.api.interfaces.dto.SubwayStationDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/subway-stations")
class SubwayStationController(
    private val subwayStationService: SubwayStationService,
) {
    @Operation(summary = "지하철역 이름으로 조회")
    @GetMapping("/search")
    suspend fun search(
        @RequestParam query: String,
    ): ApiResponseDto<List<SubwayStationDto.SubwayStationResponse>> {
        val subwayStations = subwayStationService.subwayStationsByName(query)

        return ApiResponseDto(
            status = "200",
            message = "OK",
            data = subwayStations.map { SubwayStationDto.SubwayStationResponse.of(it) },
        )
    }
}
