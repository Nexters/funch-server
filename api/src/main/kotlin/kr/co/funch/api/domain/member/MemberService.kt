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
        return memberRepository.findMember(ObjectId(id))
            .awaitFirstOrNull() ?: throw IllegalArgumentException()
    }
}
