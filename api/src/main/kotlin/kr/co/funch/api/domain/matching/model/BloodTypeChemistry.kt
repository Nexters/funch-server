package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.BloodType

data class BloodTypeChemistry(
    val referenceBloodType: BloodType,
    val targetBloodType: BloodType,
    val chemistryInfo: ChemistryInfo,
) {
    companion object {
        private val GREAT_GRADE_MESSAGE = "쿵짝 쿵짜작~이 잘 맞아요"
        private val GOOD_GRADE_MESSAGE = "우리는 최강의 콤비!"
        private val SOSO_GRADE_MESSAGE = "안정적인 관계인 우리"
        private val BAD_GRADE_MESSAGE = "서로 다른 점을 찾는 재미"

        private val CHEMISTRY_TITLE_MAP: Map<Pair<BloodType, BloodType>, String>

        init {
            val tempMap = mutableMapOf<Pair<BloodType, BloodType>, String>()
            // A형
            tempMap[Pair(BloodType.A, BloodType.A)] = GOOD_GRADE_MESSAGE
            tempMap[Pair(BloodType.A, BloodType.B)] = BAD_GRADE_MESSAGE
            tempMap[Pair(BloodType.A, BloodType.AB)] = GOOD_GRADE_MESSAGE
            tempMap[Pair(BloodType.A, BloodType.O)] = GREAT_GRADE_MESSAGE

            // B형
            tempMap[Pair(BloodType.B, BloodType.A)] = BAD_GRADE_MESSAGE
            tempMap[Pair(BloodType.B, BloodType.B)] = GOOD_GRADE_MESSAGE
            tempMap[Pair(BloodType.B, BloodType.AB)] = GREAT_GRADE_MESSAGE
            tempMap[Pair(BloodType.B, BloodType.O)] = GREAT_GRADE_MESSAGE

            // AB형
            tempMap[Pair(BloodType.AB, BloodType.A)] = GOOD_GRADE_MESSAGE
            tempMap[Pair(BloodType.AB, BloodType.B)] = GREAT_GRADE_MESSAGE
            tempMap[Pair(BloodType.AB, BloodType.AB)] = GREAT_GRADE_MESSAGE
            tempMap[Pair(BloodType.AB, BloodType.O)] = BAD_GRADE_MESSAGE

            // O형
            tempMap[Pair(BloodType.O, BloodType.A)] = GREAT_GRADE_MESSAGE
            tempMap[Pair(BloodType.O, BloodType.B)] = GREAT_GRADE_MESSAGE
            tempMap[Pair(BloodType.O, BloodType.AB)] = BAD_GRADE_MESSAGE
            tempMap[Pair(BloodType.O, BloodType.O)] = SOSO_GRADE_MESSAGE

            CHEMISTRY_TITLE_MAP = tempMap.toMap()
        }

        fun of(
            referenceBloodType: BloodType,
            targetBloodType: BloodType,
            targetMemberName: String,
        ): BloodTypeChemistry {
            return BloodTypeChemistry(
                referenceBloodType,
                targetBloodType,
                chemistryInfo =
                    ChemistryInfo(
                        title = getChemistryTitle(referenceBloodType, targetBloodType),
                        description =
                            "${targetBloodType}형인 ${targetMemberName}님은 " +
                                "${referenceBloodType.additionalInfo}!",
                    ),
            )
        }

        private fun getChemistryTitle(
            referenceBloodType: BloodType,
            targetBloodType: BloodType,
        ): String {
            return CHEMISTRY_TITLE_MAP[Pair(referenceBloodType, targetBloodType)]
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
