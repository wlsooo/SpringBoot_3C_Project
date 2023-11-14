//package com.example.CProject.service;
//
//import com.example.CProject.dto.MemberDTO;
//import com.example.CProject.entity.MemberEntity;
//import com.example.CProject.repository.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.swing.text.html.Option;
//import java.lang.reflect.Member;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class MemberService {
//    private final MemberRepository memberRepository;
//    public void save(MemberDTO memberDTO){
//        // 1. dto -> entity 변환
//        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
//        memberRepository.save(memberEntity);
//        // 2. repository의 save메서드 호출
//        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야 함)
//    }
//
//    public MemberDTO login(MemberDTO memberDTO) {
//        /* 회원이 입력한 이메일로 DB에서 조회를 함
//        DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단 */
//        Optional<MemberEntity> byMemberPass = memberRepository.findByMemberPass(memberDTO.getMemberPass());
//        if(byMemberPass.isPresent()) {
//            //조회 결과가 있다(해당 이메일을 가진 회원 정보가 있다)
//            //entity는 db의 값이고 dto는 입력값이다
//            MemberEntity memberEntity = byMemberPass.get();
//            if(memberEntity.getMemberPass().equals(memberDTO.getMemberPass())) {
//                // password 일치
//                //entity -> dto 변환 후 리턴
//                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
//                return dto;
//            } else {
//                return null;
//            }
//        } else {
//            //조회 결과가 없다(해당 이메일을 가진 회원이 없다)
//            return null;
//        }
//    }
//}





package com.example.CProject.service;

import com.example.CProject.dto.MemberDTO;
import com.example.CProject.entity.MemberEntity;
import com.example.CProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean isMemberIdUnique(String memberId) {
        return !memberRepository.existsByMemberId(memberId);
    }

    public boolean isPasswordMatching(String password, String chkPassword) {
        return password.equals(chkPassword);
    }

    public boolean isValidEmailFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public void registerMember(MemberDTO memberDTO) {
        if (isMemberIdUnique(memberDTO.getMemberId()) &&
                isPasswordMatching(memberDTO.getMemberPass(), memberDTO.getMemberChkPass()) &&
                isValidEmailFormat(memberDTO.getMemberEmail())) {

            MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
            memberRepository.save(memberEntity);
        } else {
            // 필요한 처리 (예외 던지기, 에러 메시지 출력 등)
            System.out.println("성공!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byMemberPass = memberRepository.findByMemberPass(memberDTO.getMemberPass());
        if (byMemberPass.isPresent()) {
            MemberEntity memberEntity = byMemberPass.get();
            if (memberEntity.getMemberPass().equals(memberDTO.getMemberPass())) {
                return MemberDTO.toMemberDTO(memberEntity);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}


