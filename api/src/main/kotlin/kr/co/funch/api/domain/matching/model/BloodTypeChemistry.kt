package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.BloodType

data class BloodTypeChemistry(
    val referenceBloodType: BloodType,
    val targetBloodType: BloodType,
    val chemistryInfo: ChemistryInfo,
) {
    companion object {
        private val GREAT_GRADE_MESSAGE = ChemistryInfo("쿵짝 쿵짜작~이 잘 맞아요", "미정")
        private val GOOD_GRADE_MESSAGE = ChemistryInfo("우리는 최강의 콤비!", "미정")
        private val SOSO_GRADE_MESSAGE = ChemistryInfo("안정적인 관계인 우리", "미정")
        private val BAD_GRADE_MESSAGE = ChemistryInfo("서로 다른 점을 찾는 재미", "미정")

        private val CHEMISTRY_MAP = HashMap<Pair<BloodType, BloodType>, ChemistryInfo>()

        init {
            // A형
            CHEMISTRY_MAP[Pair(BloodType.A, BloodType.A)] = GOOD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.A, BloodType.B)] = BAD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.A, BloodType.AB)] = GOOD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.A, BloodType.O)] = GREAT_GRADE_MESSAGE

            // B형
            CHEMISTRY_MAP[Pair(BloodType.B, BloodType.A)] = BAD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.B, BloodType.B)] = GOOD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.B, BloodType.AB)] = GREAT_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.B, BloodType.O)] = GREAT_GRADE_MESSAGE

            // AB형
            CHEMISTRY_MAP[Pair(BloodType.AB, BloodType.A)] = GOOD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.AB, BloodType.B)] = GREAT_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.AB, BloodType.AB)] = GREAT_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.AB, BloodType.O)] = BAD_GRADE_MESSAGE

            // O형
            CHEMISTRY_MAP[Pair(BloodType.O, BloodType.A)] = GREAT_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.O, BloodType.B)] = GREAT_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.O, BloodType.AB)] = BAD_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(BloodType.O, BloodType.O)] = SOSO_GRADE_MESSAGE
        }

        fun of(
            referenceBloodType: BloodType,
            targetBloodType: BloodType,
        ): BloodTypeChemistry {
            return BloodTypeChemistry(
                referenceBloodType,
                targetBloodType,
                getChemistryInfo(referenceBloodType, targetBloodType),
            )
        }

        private fun getChemistryInfo(
            referenceBloodType: BloodType,
            targetBloodType: BloodType,
        ): ChemistryInfo {
            return CHEMISTRY_MAP[Pair(referenceBloodType, targetBloodType)]
                ?: throw IllegalArgumentException(
                    "ChemistryMessage not found : $referenceBloodType," +
                        " $targetBloodType",
                )
        }
    }

    fun isEqualBloodType(): Boolean {
        return referenceBloodType == targetBloodType
    }
}
