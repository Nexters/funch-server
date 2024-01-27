package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Constellation

data class ConstellationChemistry(
    val referenceConstellation: Constellation,
    val targetConstellation: Constellation,
    val message: Message,
) {
    companion object {
        private val CHEMISTRY_MAP = HashMap<Pair<Constellation, Constellation>, Message>()

        fun of(
            referenceConstellation: Constellation,
            targetConstellation: Constellation,
        ): ConstellationChemistry {
            return ConstellationChemistry(
                referenceConstellation,
                targetConstellation,
                getChemistryMessage(referenceConstellation, targetConstellation),
            )
        }

        private fun getChemistryMessage(
            referenceConstellation: Constellation,
            targetConstellation: Constellation,
        ): Message {
            return CHEMISTRY_MAP[Pair(referenceConstellation, targetConstellation)]
                ?: throw IllegalArgumentException(
                    "ChemistryMessage not found : $referenceConstellation," +
                        " $targetConstellation",
                )
        }
    }

    fun isEqualConstellation(): Boolean {
        return referenceConstellation == targetConstellation
    }

    data class Message(
        val title: String,
        val description: String,
    )
}
