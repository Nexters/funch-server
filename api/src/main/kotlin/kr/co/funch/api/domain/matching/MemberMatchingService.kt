package kr.co.funch.api.domain.matching

import kr.co.funch.api.domain.matching.model.BloodTypeChemistry
import kr.co.funch.api.domain.matching.model.MbtiChemistry
import kr.co.funch.api.domain.matching.model.MemberMatching
import kr.co.funch.api.domain.member.MemberService
import org.springframework.stereotype.Service

@Service
class MemberMatchingService(
    private val memberService: MemberService,
) {
    suspend fun getMatchingInfo(
        requestMemberId: String,
        targetMemberCode: String,
    ): MemberMatching {
        val requestMember = memberService.findMember(requestMemberId)
        val targetMember = memberService.findMemberByCode(targetMemberCode)

        require(!requestMember.isSameMember(targetMember)) {
            "request member is the same with target member - member key: ${requestMember.id}"
        }

        val mbtiChemistry =
            MbtiChemistry.of(
                requestMember.mbti,
                targetMember.mbti,
                targetMember.name,
            )
        val bloodTypeChemistry =
            BloodTypeChemistry.of(
                requestMember.bloodType,
                targetMember.bloodType,
                targetMember.name,
            )
        val matchedClubs = requestMember.getMatchedClubs(targetMember)
        val matchedSubwayStations = requestMember.getMatchedSubwayStations(targetMember)
        val matchedSubwayLine = requestMember.getMatchedSubwayLine(targetMember)

        memberService.updateTargetMemberAfterMatching(targetMember)

        return MemberMatching(
            targetMember,
            mbtiChemistry,
            bloodTypeChemistry,
            requestMember.hasSameJobGroup(targetMember),
            matchedClubs,
            matchedSubwayStations,
            matchedSubwayLine,
        )
    }

    suspend fun canMatching(targetMemberCode: String): Boolean {
        // TODO: 호출 결과가 false이면 예외 발생 -> GlobalExceptionHandler 타도록 수정
        return memberService.existsMemberByMemberCode(targetMemberCode)
    }
}
