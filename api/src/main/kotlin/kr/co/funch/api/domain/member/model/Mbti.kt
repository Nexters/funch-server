package kr.co.funch.api.domain.member.model

import com.fasterxml.jackson.annotation.JsonCreator

enum class Mbti(val additionalInfo: String) {
    ENFJ("사심없는 따뜻함을 가진 인자한 지도자 타입"),
    ENFP("감당불가 친화력을 가진 인간 리트리버 타입"),
    ENTJ("비전을 향해 적극적으로 이끄는 리더 타입"),
    ENTP("새로움과 변화를 추구하는 도전가 타입"),
    ESFJ("친절과 헌신이 모토인 나이팅게일 타입"),
    ESFP("분위기 메이커를 담당하는 파티피플 타입"),
    ESTJ("원칙을 반드시 지키는 엄격한 지도자 타입"),
    ESTP("걱정없이 세상만사 잘 풀리는 자유의 영혼"),
    INFJ("자신의 도덕적 기준이 엄격한 선도부 타입"),
    INFP("홀로 공상에 빠져버리고 마는 집순이 타입"),
    INTJ("목표 위해 끊임없이 노력하는 전략가 타입"),
    INTP("세상을 왕따시키는 무관심쟁이 타입"),
    ISFJ("내향인 중 외향인! 다정하고 따뜻한 타입"),
    ISFP("따뜻한 감성을 가진 프로취존러 타입"),
    ISTJ("한번 시작한 일은 끝내는 불도저 타입"),
    ISTP("재주가 많지만 시작이 힘든 귀차니스트"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun from(value: String): Mbti {
            return Mbti.valueOf(value.uppercase())
        }
    }
}
