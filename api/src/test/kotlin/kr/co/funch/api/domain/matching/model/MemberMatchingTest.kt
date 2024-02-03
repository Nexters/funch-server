package kr.co.funch.api.domain.matching.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kr.co.funch.api.domain.member.model.BloodType
import kr.co.funch.api.domain.member.model.Club
import kr.co.funch.api.domain.member.model.JobGroup
import kr.co.funch.api.domain.member.model.Mbti
import kr.co.funch.api.domain.member.model.Member
import java.time.LocalDateTime

class MemberMatchingTest : BehaviorSpec() {
    init {

        Given("MemberMatching에서") {
            val targetMember =
                Member(
                    name = "test",
                    bloodType = BloodType.O,
                    jobGroup = JobGroup.DEVELOPER,
                    clubs = listOf(Club.NEXTERS, Club.SOPT),
                    subwayStations = emptyList(),
                    createdAt = LocalDateTime.now(),
                    updatedAt = LocalDateTime.now(),
                    deviceNumber = "test",
                    mbti = Mbti.ISTJ,
                )

            val memberMatching =
                MemberMatching(
                    targetMember = targetMember,
                    mbtiChemistry = MbtiChemistry.of(Mbti.ISTJ, Mbti.ISTJ),
                    bloodTypeChemistry =
                        BloodTypeChemistry.of(
                            BloodType.O,
                            BloodType.A,
                        ),
                    jobMatching = true,
                    matchingClubInfo = listOf(Club.NEXTERS),
                    matchingSubwayInfo = emptyList(),
                )

            When("calculateSimilarity를 하면") {
                val similarity = memberMatching.calculateSimilarity()

                Then("값이 정상적으로 계산된다") {
                    similarity shouldBe 60
                }
            }
        }
    }
}
