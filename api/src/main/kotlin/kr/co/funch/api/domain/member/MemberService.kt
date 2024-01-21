package kr.co.funch.api.domain.member

import com.mongodb.DuplicateKeyException
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
            .awaitFirstOrNull() ?: throw IllegalArgumentException("Member not found - id: $id")
    }

    suspend fun createMember(member: Member, subwayStationIds: List<String>): Member {
        return try {
            memberRepository.save(member)
                .awaitFirstOrNull()
                ?: throw IllegalArgumentException()
            // TODO : exception handling for duplicate key
        } catch(e: Exception) {
            throw IllegalArgumentException("Member didn't saved - deviceNumber: ${member.deviceNumber}")
        }
    }
}
