package kr.co.funch.api.domain.matching

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.matching.model.MatchingRecord
import org.bson.types.ObjectId
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface MatchingRecordRepository : ReactiveMongoRepository<MatchingRecord, ObjectId>, MatchingRecordRepositoryCustom

interface MatchingRecordRepositoryCustom {
    suspend fun findRecordByTargetMemberCode(
        requestMemberId: String,
        targetMemberCode: String,
    ): MatchingRecord?

    suspend fun findRecordByRequestMemberId(requestMemberId: String): List<MatchingRecord>
}

@Repository
class MatchingRecordRepositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDispatcher: CoroutineDispatcher,
) : MatchingRecordRepositoryCustom {
    override suspend fun findRecordByTargetMemberCode(
        requestMemberId: String,
        targetMemberCode: String,
    ): MatchingRecord? =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("requestMemberId").`is`(requestMemberId)
                .and("targetMemberCode").`is`(targetMemberCode)

            mongoOperations.findOne(Query(criteria), MatchingRecord::class.java)
                .awaitFirstOrNull()
        }

    override suspend fun findRecordByRequestMemberId(requestMemberId: String): List<MatchingRecord> =
        withContext(ioDispatcher) {
            val criteria = Criteria()
            criteria
                .and("requestMemberId").`is`(requestMemberId)

            val query =
                Query(criteria)
                    .with(Sort.by(Sort.Direction.DESC, "updatedAt"))
                    .limit(10)
            mongoOperations.find(query, MatchingRecord::class.java)
                .collectList().awaitFirstOrNull() ?: emptyList()
        }
}
