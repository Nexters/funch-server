package kr.co.funch.api.domain.matching.model

import kr.co.funch.api.domain.member.model.Constellation

data class ConstellationChemistry(
    val referenceConstellation: Constellation,
    val targetConstellation: Constellation,
    val chemistryInfo: ChemistryInfo,
) {
    companion object {
        private val A_GRADE_MESSAGE = ChemistryInfo("쿵짝 쿵짜작~이 잘 맞아요", "미정")
        private val B_GRADE_MESSAGE = ChemistryInfo("서로 비슷한 똑! 닮은 꼴", "미정")
        private val C_GRADE_MESSAGE = ChemistryInfo("서로를 이해하기 쉬워요", "미정")
        private val D_GRADE_MESSAGE = ChemistryInfo("안정적인 관계인 우리", "미정")
        private val E_GRADE_MESSAGE = ChemistryInfo("우리는 최강의 콤비!", "미정")
        private val F_GRADE_MESSAGE = ChemistryInfo("서로 닮고 싶은 이상적인 사이", "미정")
        private val G_GRADE_MESSAGE = ChemistryInfo("서로 다른 점을 찾는 재미", "미정")
        private val H_GRADE_MESSAGE = ChemistryInfo("서로를 조심히 알아가봐요", "미정")

        private val CHEMISTRY_MAP = HashMap<Pair<Constellation, Constellation>, ChemistryInfo>()

        init {
            // 물고기자리
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.ARIES)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.TAURUS)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.GEMINI)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.CANCER)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.LEO)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.VIRGO)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.LIBRA)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.SCORPIO)] = B_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.SAGITTARIUS)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.CAPRICORN)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.AQUARIUS)] = H_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.PISCES, Constellation.PISCES)] = B_GRADE_MESSAGE

            // 물병자리
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.ARIES)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.TAURUS)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.GEMINI)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.CANCER)] = H_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.LEO)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.VIRGO)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.LIBRA)] = B_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.SCORPIO)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.SAGITTARIUS)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.CAPRICORN)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.AQUARIUS, Constellation.AQUARIUS)] = A_GRADE_MESSAGE

            // 염소자리
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.ARIES)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.TAURUS)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.GEMINI)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.CANCER)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.LEO)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.VIRGO)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.LIBRA)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.SCORPIO)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.SAGITTARIUS)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CAPRICORN, Constellation.CAPRICORN)] = B_GRADE_MESSAGE

            // 사수자리
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.ARIES)] = B_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.TAURUS)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.GEMINI)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.CANCER)] = H_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.LEO)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.VIRGO)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.LIBRA)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.SCORPIO)] = H_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SAGITTARIUS, Constellation.SAGITTARIUS)] = B_GRADE_MESSAGE

            // 전갈자리
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.ARIES)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.TAURUS)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.GEMINI)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.CANCER)] = B_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.LEO)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.VIRGO)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.LIBRA)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.SCORPIO, Constellation.SCORPIO)] = B_GRADE_MESSAGE

            // 천칭자리
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.ARIES)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.TAURUS)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.GEMINI)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.CANCER)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.LEO)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.VIRGO)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LIBRA, Constellation.LIBRA)] = A_GRADE_MESSAGE

            // 처녀자리
            CHEMISTRY_MAP[Pair(Constellation.VIRGO, Constellation.ARIES)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.VIRGO, Constellation.TAURUS)] = A_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.VIRGO, Constellation.GEMINI)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.VIRGO, Constellation.CANCER)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.VIRGO, Constellation.LEO)] = F_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.VIRGO, Constellation.VIRGO)] = B_GRADE_MESSAGE

            // 사자자리
            CHEMISTRY_MAP[Pair(Constellation.LEO, Constellation.ARIES)] = B_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LEO, Constellation.TAURUS)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LEO, Constellation.GEMINI)] = D_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LEO, Constellation.CANCER)] = H_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.LEO, Constellation.LEO)] = A_GRADE_MESSAGE

            // 게자리
            CHEMISTRY_MAP[Pair(Constellation.CANCER, Constellation.ARIES)] = G_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CANCER, Constellation.TAURUS)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CANCER, Constellation.GEMINI)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.CANCER, Constellation.CANCER)] = B_GRADE_MESSAGE

            // 쌍둥이자리
            CHEMISTRY_MAP[Pair(Constellation.GEMINI, Constellation.ARIES)] = E_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.GEMINI, Constellation.TAURUS)] = H_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.GEMINI, Constellation.GEMINI)] = B_GRADE_MESSAGE

            // 쌍둥이자리
            CHEMISTRY_MAP[Pair(Constellation.TAURUS, Constellation.ARIES)] = C_GRADE_MESSAGE
            CHEMISTRY_MAP[Pair(Constellation.TAURUS, Constellation.TAURUS)] = B_GRADE_MESSAGE

            // 양자리
            CHEMISTRY_MAP[Pair(Constellation.ARIES, Constellation.ARIES)] = B_GRADE_MESSAGE

            CHEMISTRY_MAP.entries
                .filter { it.key.first != it.key.second }
                .forEach {
                    CHEMISTRY_MAP[Pair(it.key.second, it.key.first)] = it.value
                }
        }

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
