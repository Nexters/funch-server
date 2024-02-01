package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Mbti

data class MbtiChemistry(
    val referenceMbti: Mbti,
    val targetMbti: Mbti,
    val chemistryInfo: ChemistryInfo,
) {
    companion object {
        private val WORST_MESSAGE = "펀치가 아니면 몰랐을 사이"
        private val BAD_MESSAGE = "서로를 알아가볼까요?"
        private val NORMAL_MESSAGE = "끈끈한 사이로 발전할 수 있어요!"
        private val GOOD_MESSAGE = "기막힌 타이밍에 등장한 너!"
        private val BEST_MESSAGE = "찾았다, 내 소울메이트!"

        private val CHEMISTRY_TITLE_MAP: Map<Pair<Mbti, Mbti>, String>

        init {
            val tempMap = mutableMapOf<Pair<Mbti, Mbti>, String>()
            // ESTJ
            tempMap[Pair(Mbti.ESTJ, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.INTJ)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.INTP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ENTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ISFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ESFP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ISTP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ESTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ISFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ESFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ISTJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ESTJ, Mbti.ESTJ)] = GOOD_MESSAGE

            // ISTJ
            tempMap[Pair(Mbti.ISTJ, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.INTJ)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.INTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ENTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ISFP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ESFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ISTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ESTP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ISFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ESFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ISTJ, Mbti.ISTJ)] = GOOD_MESSAGE

            // ESFJ
            tempMap[Pair(Mbti.ESFJ, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.INTJ)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.INTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ENTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ISFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ESFP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ISTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ESTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ISFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ESFJ, Mbti.ESFJ)] = GOOD_MESSAGE

            // ISFJ
            tempMap[Pair(Mbti.ISFJ, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.INTJ)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.INTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ENTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ISFP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ESFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ISTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ESTP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ISFJ, Mbti.ISFJ)] = GOOD_MESSAGE

            // ESTP
            tempMap[Pair(Mbti.ESTP, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.INTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.INTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ENTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ISFP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ESFP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ISTP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESTP, Mbti.ESTP)] = BAD_MESSAGE

            // ISTP
            tempMap[Pair(Mbti.ISTP, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.INTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.INTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ENTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ISFP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ESFP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ISTP, Mbti.ISTP)] = BAD_MESSAGE

            // ESFP
            tempMap[Pair(Mbti.ESFP, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.ENFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.INTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.INTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.ENTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.ISFP)] = BAD_MESSAGE
            tempMap[Pair(Mbti.ESFP, Mbti.ESFP)] = BAD_MESSAGE

            // ISFP
            tempMap[Pair(Mbti.ISFP, Mbti.INFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.ENFP)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.INFJ)] = WORST_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.ENFJ)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.INTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.ENTJ)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.INTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.ENTP)] = NORMAL_MESSAGE
            tempMap[Pair(Mbti.ISFP, Mbti.ISFP)] = BAD_MESSAGE

            // ENTP
            tempMap[Pair(Mbti.ENTP, Mbti.INFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.ENFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.INFJ)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.ENFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.INTJ)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.ENTJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.INTP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTP, Mbti.ENTP)] = GOOD_MESSAGE

            // INTP
            tempMap[Pair(Mbti.INTP, Mbti.INFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTP, Mbti.ENFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTP, Mbti.INFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTP, Mbti.ENFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTP, Mbti.INTJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTP, Mbti.ENTJ)] = BEST_MESSAGE
            tempMap[Pair(Mbti.INTP, Mbti.INTP)] = GOOD_MESSAGE

            // ENTJ
            tempMap[Pair(Mbti.ENTJ, Mbti.INFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ENTJ, Mbti.ENFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTJ, Mbti.INFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTJ, Mbti.ENFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTJ, Mbti.INTJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENTJ, Mbti.ENTJ)] = GOOD_MESSAGE

            // INTJ
            tempMap[Pair(Mbti.INTJ, Mbti.INFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTJ, Mbti.ENFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.INTJ, Mbti.INFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTJ, Mbti.ENFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INTJ, Mbti.INTJ)] = GOOD_MESSAGE

            // ENFJ
            tempMap[Pair(Mbti.ENFJ, Mbti.INFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.ENFJ, Mbti.ENFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENFJ, Mbti.INFJ)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENFJ, Mbti.ENFJ)] = GOOD_MESSAGE

            // INFJ
            tempMap[Pair(Mbti.INFJ, Mbti.INFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.INFJ, Mbti.ENFP)] = BEST_MESSAGE
            tempMap[Pair(Mbti.INFJ, Mbti.INFJ)] = GOOD_MESSAGE

            // ENFP
            tempMap[Pair(Mbti.ENFP, Mbti.INFP)] = GOOD_MESSAGE
            tempMap[Pair(Mbti.ENFP, Mbti.ENFP)] = GOOD_MESSAGE

            // INFP
            tempMap[Pair(Mbti.INFP, Mbti.INFP)] = GOOD_MESSAGE

            tempMap.entries
                .filter { it.key.first != it.key.second }
                .forEach {
                    tempMap[Pair(it.key.second, it.key.first)] = it.value
                }

            CHEMISTRY_TITLE_MAP = tempMap.toMap()
        }

        fun of(
            referenceMbti: Mbti,
            targetMbti: Mbti,
            targetMemberName: String,
        ): MbtiChemistry {
            return MbtiChemistry(
                referenceMbti = referenceMbti,
                targetMbti = targetMbti,
                chemistryInfo =
                    ChemistryInfo(
                        title = getChemistryTitle(referenceMbti, targetMbti),
                        description = "${targetMbti}인 ${targetMemberName}님은 ${targetMbti.additionalInfo}!",
                    ),
            )
        }

        private fun getChemistryTitle(
            referenceMbti: Mbti,
            targetMbti: Mbti,
        ): String {
            return CHEMISTRY_TITLE_MAP[Pair(referenceMbti, targetMbti)]
                ?: throw IllegalArgumentException("ChemistryMessage not found : $referenceMbti, $targetMbti")
        }
    }

    fun isEqualMbti(): Boolean {
        return referenceMbti == targetMbti
    }
}
