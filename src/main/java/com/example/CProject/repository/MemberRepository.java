package com.example.CProject.repository;

import com.example.CProject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    // 이메일로 회원 정보 조회 (select * from member_table where member_email=?))
    Optional<MemberEntity> findByMemberPass(String memberPass);
//    boolean existsByMemberId(String memberId);  //아이디 중복확인
}
