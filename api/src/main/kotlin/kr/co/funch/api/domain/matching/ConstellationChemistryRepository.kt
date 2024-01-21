package kr.co.funch.api.domain.matching

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.withContext
import kr.co.funch.api.domain.matching.model.ConstellationChemistry
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface ConstellationChemistryRepository :
    ReactiveMongoRepository<ConstellationChemistry, ConstellationChemistry.ConstellationChemistryId>,
    ConstellationChemistryRepositoryCustom

interface ConstellationChemistryRepositoryCustom {
    suspend fun findConstellationByid(id: ConstellationChemistry.ConstellationChemistryId): ConstellationChemistry?
}

@Repository
class ConstellationChemistryRespositoryCustomImpl(
    private val mongoOperations: ReactiveMongoOperations,
    private val ioDisPatcher: CoroutineDispatcher,
) : ConstellationChemistryRepositoryCustom {
    override suspend fun findConstellationByid(
        id: ConstellationChemistry.ConstellationChemistryId,
    ): ConstellationChemistry? =
        withContext(ioDisPatcher) {
            val criteria = Criteria()
            criteria
                .and("id").`is`(id)

            mongoOperations.findOne(Query(criteria), ConstellationChemistry::class.java)
                .awaitFirstOrNull()
        }
}
