package kr.co.funch.api.domain.member

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface MemberRepository : ReactiveMongoRepository<Member, ObjectId>, MemberRepositoryCustom

interface MemberRepositoryCustom {
    suspend fun findMemberById(id: ObjectId): Member?

    suspend fun findMemberByDeviceNumber(deviceNumber: String): Member?

    suspend fun findByCode(code: String): Member?

    suspend fun deleteMemberById(id: ObjectId): Long?

    suspend fun existsMemberByCode(code: String): Boolean?
}

@Repository
class MemberRepositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDispatcher: CoroutineDispatcher,
) : MemberRepositoryCustom {
    override suspend fun findMemberById(id: ObjectId): Member? =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("id").`is`(id)

            mongoOperations.findOne(Query(criteria), Member::class.java)
                .awaitFirstOrNull()
        }

    override suspend fun findMemberByDeviceNumber(deviceNumber: String): Member? =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("deviceNumber").`is`(deviceNumber)

            mongoOperations.findOne(Query(criteria), Member::class.java)
                .awaitFirstOrNull()
        }

    override suspend fun findByCode(code: String): Member? =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("code").`is`(code).regex(code, "i")

            mongoOperations.findOne(Query(criteria), Member::class.java)
                .awaitFirstOrNull()
        }

    override suspend fun deleteMemberById(id: ObjectId): Long? =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("id").`is`(id)

            val result =
                mongoOperations.remove(Query(criteria), Member::class.java)
                    .awaitFirstOrNull()

            result?.deletedCount
        }

    override suspend fun existsMemberByCode(code: String): Boolean? =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("code").`is`(code)

            mongoOperations.exists(Query(criteria), Member::class.java)
                .awaitFirstOrNull()
        }
}
