package com.example.CProject.entity;

import com.example.CProject.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {
    @Id //pk 설정
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment, String에는 사용할 수 없음
    private String memberId;

    @Column
    private String memberPass;

    @Column
    private String memberChkPass;

    @Column(unique = true)  //unique 조건 생성
    private String memberEmail;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPass(memberDTO.getMemberPass());
        memberEntity.setMemberChkPass(memberDTO.getMemberChkPass());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        return memberEntity;
    }
}
