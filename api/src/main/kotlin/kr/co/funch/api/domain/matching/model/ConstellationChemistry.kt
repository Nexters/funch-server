package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Constellation
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "ConstellationChemistry")
data class ConstellationChemistry(
    @Id
    val id: ConstellationChemistryId,
    val message: String,
) {
    data class ConstellationChemistryId(
        val referenceConstellation: Constellation,
        val targetConstellation: Constellation,
    )

    fun isEqualConstellation(): Boolean {
        return id.referenceConstellation == id.targetConstellation
    }
}
