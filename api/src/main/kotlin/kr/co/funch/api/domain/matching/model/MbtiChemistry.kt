package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Mbti
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "MbtiChemistry")
data class MbtiChemistry(
    @Id
    val id: MbtiChemistryId,
    val message: String,
) {
    data class MbtiChemistryId(
        val referenceMbti: Mbti,
        val targetMbti: Mbti,
    )

    fun isEqualMbti(): Boolean {
        return id.referenceMbti == id.targetMbti
    }
}
