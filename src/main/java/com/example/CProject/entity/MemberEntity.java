package com.example.CProject.entity;

import com.example.CProject.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
@Table(name = "member_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @Column(name = "member_id", nullable = false, length = 10)
    private String memberId;

    @Column(name = "member_pass", nullable = false, length = 20, unique = true)
    private String memberPass;

    @Column(name = "member_chk_pass", nullable = false, length = 20, unique = true)
    private String memberChkPass;

    @Column(name = "member_email", nullable = false, length = 50, unique = true)
    private String memberEmail;

    // Getter, Setter 등의 메서드 생략

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        memberEntity.setMemberPass(memberDTO.getMemberPass());
        memberEntity.setMemberChkPass(memberDTO.getMemberChkPass());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        return memberEntity;
    }
}

