package kr.co.funch.api.domain.member

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

interface MemberRepository : ReactiveMongoRepository<Member, ObjectId>, MemberRepositoryCustom

interface MemberRepositoryCustom {
    suspend fun findMember(id: ObjectId): Mono<Member>
}

@Repository
class MemberRepositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDispatcher: CoroutineDispatcher,
) : MemberRepositoryCustom {
    override suspend fun findMember(id: ObjectId): Mono<Member> {
        withContext(ioDispatcher) {
            // mongoOperations
        }
        return Member(
            id = "1",
            name = "funch",
        ).toMono()
    }
}
