package com.example.CProject.dto;

import com.example.CProject.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memberId;
    private String memberPass;
    private String memberChkPass;
    private String memberEmail;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPass='" + memberPass + '\'' +
                ", memberChkPass='" + memberChkPass + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberPass(memberEntity.getMemberPass());
        memberDTO.setMemberChkPass(memberEntity.getMemberChkPass());
        memberDTO.setMemberEmail(memberDTO.getMemberEmail());
        return memberDTO;
    }
}
