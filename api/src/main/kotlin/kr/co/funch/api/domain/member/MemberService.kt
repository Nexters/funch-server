package kr.co.funch.api.domain.member

import kotlinx.coroutines.reactive.awaitFirstOrNull
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {
    suspend fun findMember(id: String): Member {
        return memberRepository.findMemberById(ObjectId(id))
            ?: throw IllegalArgumentException("Member not found - id: $id")
    }

    suspend fun findMemberByDeviceNumber(deviceNumber: String): Member {
        return memberRepository.findMemberByDeviceNumber(deviceNumber)
            ?: throw IllegalArgumentException("Member not found - deviceNumber: $deviceNumber")
    }

    suspend fun createMember(
        member: Member,
        subwayStationIds: List<String>,
    ): Member {
        return try {
            memberRepository.save(
                member.copy(memberCode = generateMemberCode()),
            )
                .awaitFirstOrNull()
                ?: throw IllegalArgumentException()
            // TODO : exception handling for duplicate key
        } catch (e: Exception) {
            throw IllegalArgumentException("Member didn't saved - deviceNumber: ${member.deviceNumber}")
        }
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
