package kr.co.funch.api.domain.member.model

import java.time.LocalDate

enum class Constellation(val koreanName: String) {
    ARIES("양자리"),
    TAURUS("황소자리"),
    GEMINI("쌍둥이자리"),
    CANCER("게자리"),
    LEO("사자자리"),
    VIRGO("처녀자리"),
    LIBRA("천칭자리"),
    SCORPIO("전갈자리"),
    SAGITTARIUS("궁수자리"),
    CAPRICORN("염소자리"),
    AQUARIUS("물병자리"),
    PISCES("물고기자리"),
    ;

    companion object {
        fun calculatedBy(birthDate: LocalDate): Constellation {
            val month = birthDate.monthValue
            val day = birthDate.dayOfMonth

            return when (month) {
                1 -> if (day <= 19) CAPRICORN else AQUARIUS
                2 -> if (day <= 18) AQUARIUS else PISCES
                3 -> if (day <= 20) PISCES else ARIES
                4 -> if (day <= 19) ARIES else TAURUS
                5 -> if (day <= 20) TAURUS else GEMINI
                6 -> if (day <= 21) GEMINI else CANCER
                7 -> if (day <= 22) CANCER else LEO
                8 -> if (day <= 22) LEO else VIRGO
                9 -> if (day <= 22) VIRGO else LIBRA
                10 -> if (day <= 23) LIBRA else SCORPIO
                11 -> if (day <= 22) SCORPIO else SAGITTARIUS
                12 -> if (day <= 24) SAGITTARIUS else CAPRICORN
                else -> throw IllegalArgumentException("Invalid month: $month")
            }
        }
    }
}
