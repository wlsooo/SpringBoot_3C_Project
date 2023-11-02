package com.example.CProject.controller;

import com.example.CProject.dto.MemberDTO;
import com.example.CProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/join")
    public String joinForm() {return "join";}
    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        //soutp 단축키 : 매개변수 toString
        System.out.println("MemberController.join");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {return "login";}
    @PostMapping("/login")
    public String login(@RequestParam("memberId") String memberId,
                       @RequestParam("memberPass") String memberPass) {
        System.out.println("memberId : " + memberId + ", memberPass : " + memberPass);
        return "login";
    }

    @GetMapping("/choice")
    public String choice() {return "choice";}
}