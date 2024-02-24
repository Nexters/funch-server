package kr.co.funch.api.domain.matching.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "MatchingRecords")
data class MatchingRecord(
    @Id
    val id: ObjectId? = null,
    val requestMemberId: String,
    val targetMemberCode: String,
    val memberMatching: MemberMatching,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
