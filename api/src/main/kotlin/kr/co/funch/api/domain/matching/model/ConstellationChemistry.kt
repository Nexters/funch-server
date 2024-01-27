package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Constellation

data class ConstellationChemistry(
    val referenceConstellation: Constellation,
    val targetConstellation: Constellation,
    val chemistryInfo: ChemistryInfo,
) {
    companion object {
        private val CHEMISTRY_MAP = HashMap<Pair<Constellation, Constellation>, ChemistryInfo>()

        fun of(
            referenceConstellation: Constellation,
            targetConstellation: Constellation,
        ): ConstellationChemistry {
            return ConstellationChemistry(
                referenceConstellation,
                targetConstellation,
                getChemistryInfo(referenceConstellation, targetConstellation),
            )
        }

        private fun getChemistryInfo(
            referenceConstellation: Constellation,
            targetConstellation: Constellation,
        ): ChemistryInfo {
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
}
