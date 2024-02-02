package kr.co.funch.api.domain.member

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.member.model.SubwayStation
import org.bson.types.ObjectId
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface SubwayStationRepository : ReactiveMongoRepository<SubwayStation, ObjectId>, SubwayStationRepositoryCustom

interface SubwayStationRepositoryCustom {
    suspend fun search(query: String): List<SubwayStation>
}

@Repository
class SubwayStationRepositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDispatcher: CoroutineDispatcher,
) : SubwayStationRepositoryCustom {
    override suspend fun search(query: String): List<SubwayStation> =
        withContext(ioDispatcher) {
            val criteria = Criteria().and("name").regex(query.trim(), "i")

            mongoOperations.find(
                Query(criteria).with(Sort.by(Sort.Order.asc("name"))).limit(5),
                SubwayStation::class.java,
            )
                .collectList()
                .awaitSingle()
        }
}
