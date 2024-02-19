package kr.co.funch.api.domain.member.model

import com.fasterxml.jackson.annotation.JsonCreator

enum class BloodType(val additionalInfo: String) {
    A("꼼꼼하고 배려심있지만 부끄러움이 많아요"),
    B("호기심과 창의력을 갖췄지만 변덕스러워요"),
    AB("브레인으로 불리지만 감정기복이 심해요"),
    O("열정과 노력이 있지만 겸손함이 부족해요"),
    ;

    companion object {
        @JvmStatic
        @JsonCreator
        fun from(value: String): BloodType {
            return BloodType.valueOf(value.uppercase())
        }
    }
}
