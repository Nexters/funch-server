package kr.co.funch.api.domain.member

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.matching.model.MatchingClubInfo
import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface MemberRepository : ReactiveMongoRepository<Member, ObjectId>, MemberRepositoryCustom

interface MemberRepositoryCustom {
    suspend fun findMemberById(id: ObjectId): Member?

    suspend fun findMemberByDeviceNumber(deviceNumber: String): Member?

    suspend fun getMatchedClub(targetMemberId: ObjectId, targetClubs: List<Club>, ): MatchingClubInfo?
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

    override suspend fun getMatchedClub(
        targetMemberId: ObjectId,
        targetClubs: List<Club>,
    ): MatchingClubInfo? =
        withContext(ioDispatcher) {
            val matchUser = Aggregation.match(Criteria.where("id").`is`(targetMemberId))
            val unwindClubs = Aggregation.unwind("clubs")
            val matchTargetClubs = Aggregation.match(Criteria.where("clubs").`in`(targetClubs))
            val group = Aggregation.group().addToSet("clubs").`as`("matchingClubs")

            val aggregation: Aggregation = Aggregation.newAggregation(matchUser, unwindClubs, matchTargetClubs, group)
            val result = mongoOperations.aggregate(aggregation, "Member", MatchingClubInfo::class.java)
            result.awaitFirstOrNull()
        }
}
