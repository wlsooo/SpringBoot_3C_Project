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
import com.example.CProject.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

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
            session.setAttribute("loginPass", loginResult.getMemberPass());
            return "main";
        } else {
            return "login";
        }
    }

    @GetMapping("/choice")
    public String choice() {
        return "choice";
    }
}
