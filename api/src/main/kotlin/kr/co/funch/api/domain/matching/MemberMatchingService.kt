package kr.co.funch.api.domain.matching

import kr.co.funch.api.domain.matching.model.ConstellationChemistry
import kr.co.funch.api.domain.matching.model.MbtiChemistry
import kr.co.funch.api.domain.matching.model.MemberMatching
import kr.co.funch.api.domain.matching.model.SubwayMatchingInfo
import kr.co.funch.api.domain.member.MemberService
import kr.co.funch.api.domain.member.model.Constellation
import kr.co.funch.api.domain.member.model.Mbti
import org.springframework.stereotype.Service

@Service
class MemberMatchingService(
    private val memberService: MemberService,
    private val mbtiChemistryRepository: MbtiChemistryRepository,
    private val constellationChemistryRepository: ConstellationChemistryRepository,
) {
    suspend fun getMatchingInfo(
        requestMemberId: String,
        targetMemberCode: String,
    ): MemberMatching {
        val requestMember = memberService.findMember(requestMemberId)
        // TODO: 임시로 매칭 key로 device code 사용, 매칭 시 사용하는 코드 논의 후 변경
        val matchingTargetMember = memberService.findMemberByDeviceNumber(targetMemberCode)

        val mbtiChemistry = findMbtiChemistry(requestMember.mbti, matchingTargetMember.mbti)
        val constellationChemistry =
            findConstellationChemistry(requestMember.constellation, matchingTargetMember.constellation)
        val matchingClubInfo =
            memberService.getMatchedClubOfMember(matchingTargetMember.id.toString(), requestMember.clubs)

        return MemberMatching(
            mbtiChemistry,
            constellationChemistry,
            requestMember.jobGroup == matchingTargetMember.jobGroup,
            matchingClubInfo,
            SubwayMatchingInfo("싱싱미역"),
        )
    }

    private suspend fun findMbtiChemistry(
        referenceMbti: Mbti,
        targetMbti: Mbti,
    ): MbtiChemistry =
        mbtiChemistryRepository.findMbtiChemistryById(MbtiChemistry.MbtiChemistryId(referenceMbti, targetMbti))
            ?: throw IllegalArgumentException(
                "MbtiChemistry not found - reference : $referenceMbti, target : $targetMbti",
            )

    private suspend fun findConstellationChemistry(
        referenceConstellation: Constellation,
        targetConstellation: Constellation,
    ): ConstellationChemistry =
        constellationChemistryRepository.findConstellationByid(
            ConstellationChemistry.ConstellationChemistryId(referenceConstellation, targetConstellation),
        )
            ?: throw IllegalArgumentException(
                "Constellation not found - reference : $referenceConstellation, target : $targetConstellation",
            )
}
