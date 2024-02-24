package kr.co.funch.api.domain.matching

import kr.co.funch.api.domain.matching.model.MatchingRecord
import kr.co.funch.api.domain.matching.model.MemberMatching
import kr.co.funch.api.interfaces.dto.MemberMatchingDto.MatchingRequestDto
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MatchingRecordService(
    val matchingRecordRepository: MatchingRecordRepository,
) {
    suspend fun upsertMatchingRecord(
        matchingDto: MatchingRequestDto,
        memberMatching: MemberMatching,
    ) {
        val matchingRecord: MatchingRecord? =
            matchingRecordRepository.findRecordByTargetMemberCode(
                matchingDto.requestMemberId,
                matchingDto.targetMemberCode,
            )

        matchingRecord?.let {
            matchingRecordRepository.save(
                it.copy(
                    memberMatching = memberMatching,
                    updatedAt = LocalDateTime.now(),
                ),
            ).subscribe()
        } ?: run {
            matchingRecordRepository.save(
                MatchingRecord(
                    requestMemberId = matchingDto.requestMemberId,
                    targetMemberCode = matchingDto.targetMemberCode,
                    memberMatching = memberMatching,
                    createdAt = LocalDateTime.now(),
                    updatedAt = LocalDateTime.now(),
                ),
            ).subscribe()
        }
    }

    suspend fun getMatchingRecords(requestMemberId: String): List<MatchingRecord> {
        return matchingRecordRepository.findRecordByRequestMemberId(requestMemberId)
    }
}
