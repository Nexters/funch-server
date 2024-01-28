package kr.co.funch.api.domain.member

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kr.co.funch.api.domain.member.model.Constellation
import kr.co.funch.api.domain.member.model.JobGroup
import kr.co.funch.api.domain.member.model.Mbti
import kr.co.funch.api.domain.member.model.Member
import org.bson.types.ObjectId
import java.time.LocalDate
import java.time.LocalDateTime

class MemberServiceTest : BehaviorSpec() {
    init {
        val memberRepository: MemberRepository = mockk()
        val sut =
            MemberService(
                memberRepository = memberRepository,
            )

        Given("MemberService") {
            coEvery { memberRepository.findMemberById(any()) } returns
                Member(
                    id = ObjectId("5f9f1b9b9d6b9e1b9d6b9e1b"),
                    name = "test",
                    deviceNumber = "test",
                    mbti = Mbti.ENFJ,
                    jobGroup = JobGroup.FRONTEND,
                    clubs = emptyList(),
                    subwayStations = emptyList(),
                    birthDate = LocalDate.now(),
                    age = 23,
                    constellation = Constellation.ARIES,
                    createdAt = LocalDateTime.now(),
                    updatedAt = LocalDateTime.now()
                )

            When("findMember") {
                val member = sut.findMember("5f9f1b9b9d6b9e1b9d6b9e1b")

                Then("member") {
                    member.name shouldBe "test"
                }
            }
        }
    }
}
