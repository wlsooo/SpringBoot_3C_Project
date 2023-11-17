package com.example.CProject.service;

import com.example.CProject.entity.PageInfo;
import com.example.CProject.repository.PageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class PageInfoService {

    private static final String UPLOAD_DIR = "static/images/";

    @Autowired
    private PageInfoRepository pageInfoRepository;



    public void savePageInfo(String memberId, String imageFilePath, String homePlace
                            , String people, String homeTime) {
        // 이미지 경로와 함께 pageInfo 저장
        PageInfo pageInfo = new PageInfo();
        pageInfo.setId(memberId);
        pageInfo.setImage(imageFilePath);
        pageInfo.setPlace(homePlace);
        pageInfo.setPeople(people);
        pageInfo.setTime(homeTime);

        // 이미 존재하는 경우 업데이트, 존재하지 않는 경우 저장
        Optional<PageInfo> existingPageInfo = pageInfoRepository.findById(memberId);
        if (existingPageInfo.isPresent()) {
            // 업데이트 로직 추가 (예: 이미지 경로가 변경된 경우)
            // ...
        } else {
            // 저장 로직
            pageInfoRepository.save(pageInfo);
        }
    }
}