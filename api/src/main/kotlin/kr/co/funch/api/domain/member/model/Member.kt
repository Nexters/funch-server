package kr.co.funch.api.domain.member.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Member(
    @Id
    val id: String,
    val name: String,
    // ...
)
