package kr.co.funch.api.domain.matching

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.matching.model.MbtiChemistry
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface MbtiChemistryRepository :
    ReactiveMongoRepository<MbtiChemistry, MbtiChemistry.MbtiChemistryId>, MbtiChemistryRepositoryCustom

interface MbtiChemistryRepositoryCustom {
    suspend fun findMbtiChemistryById(id: MbtiChemistry.MbtiChemistryId): MbtiChemistry?
}

@Repository
class MbtiChemistryRepositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDisPatcher: CoroutineDispatcher,
) : MbtiChemistryRepositoryCustom {
    override suspend fun findMbtiChemistryById(id: MbtiChemistry.MbtiChemistryId): MbtiChemistry? =
        withContext(ioDisPatcher) {
            val criteria = Criteria()
            criteria
                .and("id").`is`(id)

            mongoOperations.findOne(Query(criteria), MbtiChemistry::class.java)
                .awaitFirstOrNull()
        }
}
