package com.example.CProject.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

//    public MemberDTO(String memberId, String memberPass, String memberEmail) {
//        this.memberId = memberId;
//        this.memberPass = memberPass;
//        this.memberEmail = memberEmail;
//    }
}
