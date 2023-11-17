package com.example.CProject.repository;

import com.example.CProject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByMemberPass(String memberPass);

    boolean existsByMemberId(String memberId);
}
