package kr.co.funch.api.domain.member.model

import com.fasterxml.jackson.annotation.JsonCreator

enum class JobGroup(val koreanName: String) {
    DEVELOPER("개발자"),
    DESIGNER("디자이너"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun from(value: String): JobGroup {
            return JobGroup.valueOf(value.uppercase())
        }
    }
}
