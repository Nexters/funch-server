package kr.co.funch.api.domain.member

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

interface MemberRepository : ReactiveMongoRepository<Member, ObjectId>, MemberRepositoryCustom

interface MemberRepositoryCustom {
    suspend fun findMemberById(id: ObjectId): Mono<Member>
}

@Repository
class MemberRepositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDispatcher: CoroutineDispatcher,
) : MemberRepositoryCustom {
    override suspend fun findMemberById(id: ObjectId): Mono<Member> =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("id").`is`(id)

            mongoOperations.findOne(Query(criteria), Member::class.java)
        }
}
