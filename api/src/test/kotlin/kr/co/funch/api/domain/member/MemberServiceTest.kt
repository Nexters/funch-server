package kr.co.funch.api.domain.member

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kr.co.funch.api.domain.member.model.Member
import reactor.kotlin.core.publisher.toMono

class MemberServiceTest : BehaviorSpec() {
    init {
        val memberRepository: MemberRepository = mockk()
        val sut = MemberService(
            memberRepository = memberRepository,
        )

        Given("MemberService") {
            coEvery { memberRepository.findMember(any()) } returns Member(
                id = "5f9f1b9b9d6b9e1b9d6b9e1b",
                name = "test",
            ).toMono()

            When("findMember") {
                val member = sut.findMember("5f9f1b9b9d6b9e1b9d6b9e1b")

                Then("member") {
                    member.name shouldBe "test"
                }
            }
        }
    }
}
