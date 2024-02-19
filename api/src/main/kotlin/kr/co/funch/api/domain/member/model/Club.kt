package kr.co.funch.api.domain.member.model

import com.fasterxml.jackson.annotation.JsonCreator

enum class Club {
    NEXTERS,
    SOPT,
    DEPROMEET,
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun from(value: String): Club {
            return Club.valueOf(value.uppercase())
        }
    }
}
