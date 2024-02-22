package kr.co.funch.api.domain.member

import kotlinx.coroutines.reactive.awaitFirstOrNull
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val subwayStationService: SubwayStationService,
) {
    suspend fun findMember(id: String): Member {
        return memberRepository.findMemberById(ObjectId(id))
            ?: throw IllegalArgumentException("Member not found - id: $id")
    }

    suspend fun findMemberByDeviceNumber(deviceNumber: String): Member {
        return memberRepository.findMemberByDeviceNumber(deviceNumber)
            ?: throw IllegalArgumentException("Member not found - deviceNumber: $deviceNumber")
    }

    suspend fun findMemberByCode(code: String): Member {
        return memberRepository.findByCode(code)
            ?: throw IllegalArgumentException("Member not found - code : $code")
    }

    suspend fun createMember(
        member: Member,
        subwayStationNames: List<String>,
    ): Member {
        val subwayStations = subwayStationService.findSubwayStationsByNames(subwayStationNames)

        return try {
            memberRepository.save(
                member.copy(
                    code = generateMemberCode(),
                    subwayStations = subwayStations,
                ),
            )
                .awaitFirstOrNull()
                ?: throw IllegalArgumentException()
            // TODO : exception handling for duplicate key
        } catch (e: Exception) {
            throw IllegalArgumentException("Member didn't saved - deviceNumber: ${member.deviceNumber}")
        }
    }

    suspend fun updateTargetMemberAfterMatching(targetMember: Member): Member {
        return try {
            memberRepository.save(
                targetMember.increaseViewCount(),
            )
                .awaitFirstOrNull()
                ?: throw IllegalArgumentException()
        } catch (e: Exception) {
            throw IllegalArgumentException("Member didn't saved - member: $targetMember")
        }
    }

    suspend fun deleteMember(id: String) {
        try {
            val deleteCount = memberRepository.deleteMemberById(ObjectId(id))
            require(deleteCount == 1L) {
                throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("Member delete failed - id: $id")
        }
    }

    suspend fun existsMemberByMemberCode(code: String): Boolean {
        return memberRepository.existsMemberByCode(code)
            ?: throw IllegalArgumentException("existsMemberByMemberCode failed - code : $code")
    }

    private suspend fun generateMemberCode(): String {
        val letters = ('A'..'Z').toList()
        val numbers = ('0'..'9').toList()
        var code: String

        do {
            val randomLetters = List(2) { letters.random() }
            val randomNumbers = List(2) { numbers.random() }
            val combined = (randomLetters + randomNumbers).shuffled()
            code = combined.joinToString("")
        } while (memberRepository.findByCode(code) != null)

        return code
    }
}
