package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Mbti

data class MbtiChemistry(
    val referenceMbti: Mbti,
    val targetMbti: Mbti,
    val message: Message,
) {
    companion object {
        private val WORST_MESSAGE = Message("펀치가 아니면 몰랐을 사이", "미정")
        private val BAD_MESSAGE = Message("서로를 알아가볼까요?", "미정")
        private val NORMAL_MESSAGE = Message("기막힌 타이밍에 등장한 너!", "미정")
        private val GOOD_MESSAGE = Message("To be determined.", "미정")
        private val BEST_MESSAGE = Message("찾았다, 내 소울메이트!", "미정")

        private val CHEMISTRY_MAP = HashMap<Pair<Mbti, Mbti>, Message>()

        init {
            // ESTJ
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.INTJ)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.INTP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ENTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ISFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ESFP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ISTP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ESTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ISFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ESFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ISTJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTJ, Mbti.ESTJ)] = GOOD_MESSAGE

            // ISTJ
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.INTJ)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.INTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ENTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ISFP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ESFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ISTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ESTP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ISFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ESFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTJ, Mbti.ISTJ)] = GOOD_MESSAGE

            // ESFJ
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.INTJ)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.INTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ENTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ISFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ESFP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ISTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ESTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ISFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFJ, Mbti.ESFJ)] = GOOD_MESSAGE

            // ISFJ
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.INTJ)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.INTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ENTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ISFP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ESFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ISTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ESTP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFJ, Mbti.ISFJ)] = GOOD_MESSAGE

            // ESTP
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.INTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.INTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ENTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ISFP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ESFP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ISTP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESTP, Mbti.ESTP)] = BAD_MESSAGE

            // ISTP
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.INTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.INTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ENTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ISFP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ESFP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISTP, Mbti.ISTP)] = BAD_MESSAGE

            // ESFP
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.ENFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.INTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.INTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.ENTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.ISFP)] = BAD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ESFP, Mbti.ESFP)] = BAD_MESSAGE

            // ISFP
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.INFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.ENFP)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.INFJ)] = WORST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.ENFJ)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.INTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.ENTJ)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.INTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.ENTP)] = NORMAL_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ISFP, Mbti.ISFP)] = BAD_MESSAGE

            // ENTP
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.INFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.ENFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.INFJ)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.ENFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.INTJ)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.ENTJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.INTP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTP, Mbti.ENTP)] = GOOD_MESSAGE

            // INTP
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.INFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.ENFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.INFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.ENFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.INTJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.ENTJ)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTP, Mbti.INTP)] = GOOD_MESSAGE

            // ENTJ
            CHEMISTRY_MAP[Pair(Mbti.ENTJ, Mbti.INFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTJ, Mbti.ENFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTJ, Mbti.INFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTJ, Mbti.ENFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTJ, Mbti.INTJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENTJ, Mbti.ENTJ)] = GOOD_MESSAGE

            // INTJ
            CHEMISTRY_MAP[Pair(Mbti.INTJ, Mbti.INFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTJ, Mbti.ENFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTJ, Mbti.INFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTJ, Mbti.ENFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INTJ, Mbti.INTJ)] = GOOD_MESSAGE

            // ENFJ
            CHEMISTRY_MAP[Pair(Mbti.ENFJ, Mbti.INFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENFJ, Mbti.ENFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENFJ, Mbti.INFJ)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENFJ, Mbti.ENFJ)] = GOOD_MESSAGE

            // INFJ
            CHEMISTRY_MAP[Pair(Mbti.INFJ, Mbti.INFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INFJ, Mbti.ENFP)] = BEST_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.INFJ, Mbti.INFJ)] = GOOD_MESSAGE

            // ENFP
            CHEMISTRY_MAP[Pair(Mbti.ENFP, Mbti.INFP)] = GOOD_MESSAGE
            CHEMISTRY_MAP[Pair(Mbti.ENFP, Mbti.ENFP)] = GOOD_MESSAGE

            // INFP
            CHEMISTRY_MAP[Pair(Mbti.INFP, Mbti.INFP)] = GOOD_MESSAGE

            CHEMISTRY_MAP.entries
                .filter { it.key.first != it.key.second }
                .forEach {
                    CHEMISTRY_MAP[Pair(it.key.second, it.key.first)] = it.value
                }
        }

        fun of(
            referenceMbti: Mbti,
            targetMbti: Mbti,
        ): MbtiChemistry {
            return MbtiChemistry(
                referenceMbti,
                targetMbti,
                getChemistryMessage(referenceMbti, targetMbti),
            )
        }

        private fun getChemistryMessage(
            referenceMbti: Mbti,
            targetMbti: Mbti,
        ): Message {
            return CHEMISTRY_MAP[Pair(referenceMbti, targetMbti)]
                ?: throw IllegalArgumentException("ChemistryMessage not found : $referenceMbti, $targetMbti")
        }
    }

    fun isEqualMbti(): Boolean {
        return referenceMbti == targetMbti
    }

    data class Message(
        val title: String,
        val description: String,
    )
}
