package kr.co.funch.api.interfaces.dto

import kr.co.funch.api.domain.member.model.Member

data class MemberResponse(
    val id: String,
    val name: String,
) {
    companion object {
        fun of(member: Member): MemberResponse {
            return MemberResponse(
                id = member.id,
                name = member.name,
            )
        }
    }
}
