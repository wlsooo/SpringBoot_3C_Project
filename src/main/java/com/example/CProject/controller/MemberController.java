//package com.example.CProject.controller;
//
//import com.example.CProject.dto.MemberDTO;
//import com.example.CProject.service.MemberService;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequiredArgsConstructor
//public class MemberController {
//    //생성자 주입
//    private final MemberService memberService;
//
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping("/join")
//    public String joinForm() {return "join";}
//    @PostMapping("/join")
//    public String join(@ModelAttribute MemberDTO memberDTO) {
//        //soutp 단축키 : 매개변수 toString
//        System.out.println("MemberController.join");
//        System.out.println("memberDTO = " + memberDTO);
//        memberService.save(memberDTO);
//        return "login";
//    }
//
//    @GetMapping("/login")
//    public String loginForm() {
//        return "login";
//    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
//        MemberDTO loginResult = memberService.login(memberDTO);
//        if(loginResult != null) {
//            //lgoin 성공
//            session.setAttribute("loginPass", loginResult.getMemberPass());
//            return "main";
//        }else {
//            //login 실패
//            return "login";
//        }
//    }
//
//    @GetMapping("/choice")
//    public String choice() {return "choice";}
//}


package com.example.CProject.controller;

import com.example.CProject.dto.MemberDTO;
import com.example.CProject.entity.PageInfo;
import com.example.CProject.repository.PageInfoRepository;
import com.example.CProject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;
    private final PageInfoRepository pageInfoRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        memberService.registerMember(memberDTO);
        return "login";
    }

    @PostMapping("/checkDuplicate")
    @ResponseBody
    public boolean checkDuplicate(@RequestParam String memberId) {
        return memberService.isMemberIdUnique(memberId);
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getMemberId());
            System.out.println((String) session.getAttribute("loginId"));
            return "choice";
        } else {
            return "login";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        // 세션에서 memberId 가져오기
        String memberId = (String) session.getAttribute("loginId");

        // 중복 체크
        if (!isPageInfoExists(memberId)) {
            // 중복되지 않는 무작위 값 생성 (여기서는 간단하게 랜덤 숫자로 했음)
            Random random = new Random();
            int randnum = random.nextInt(1000); // 0부터 999까지의 무작위 숫자

            // page_info 테이블에 저장
            PageInfo pageInfo = new PageInfo();
            pageInfo.setId(memberId);
            pageInfo.setRandnum(randnum);
            // 나머지 필드 값 설정...

            pageInfoRepository.save(pageInfo); // pageInfoRepository는 JpaRepository를 상속한 인터페이스
        }

        return "home";
    }

    // 이미 저장된 아이디가 있는지 확인하는 메서드
    private boolean isPageInfoExists(String memberId) {
        Optional<PageInfo> pageInfoEntity = pageInfoRepository.findById(memberId);
        return pageInfoEntity.isPresent();
    }


    @GetMapping("/home/{memberId}")
    public String home(@PathVariable String memberId, Model model) {
        // 중복되지 않는 무작위 값 생성
        Random random = new Random();
        int randnum = random.nextInt(1000); // 0부터 999까지의 무작위 숫자

        // memberId와 randnum을 모델에 추가
        model.addAttribute("memberId", memberId);
        model.addAttribute("randnum", randnum);

        // 여기서 console에 출력하거나 다른 작업을 수행할 수 있습니다.
        System.out.println("Received memberId in HomeController: " + memberId);
        System.out.println("Generated randnum in HomeController: " + randnum);

        return "home";
    }

    @PostMapping("/home")
    public String saveHomeInfo(@RequestParam("homeImg") MultipartFile homeImg,
                               @RequestParam("homePlace") String homePlace,
                               @RequestParam("homeChk") List<String> homeChk,
                               @RequestParam("homePeople") List<String> homePeople,
                               @RequestParam("homeTime") String homeTime,
                               Model model, HttpSession session) {
        String memberId = (String) session.getAttribute("loginId");
        String peopleChk = String.join(",", homeChk);
        String people = String.join(",", homePeople);

        return "redirect:/home";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }
}
