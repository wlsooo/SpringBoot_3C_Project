package com.example.CProject.repository;

import com.example.CProject.entity.PageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageInfoRepository extends JpaRepository<PageInfo, String> {
    // 추가적인 쿼리 메서드가 필요하다면 여기에 추가할 수 있습니다.
}