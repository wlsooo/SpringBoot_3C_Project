//package com.example.CProject.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class FrontController {
//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }
//    @GetMapping("/join")
//    public String join() {return "join";}
//
//    @GetMapping("/login")
//    public String login() {return "login";}
//    @PostMapping("/login")
//    public String save(@RequestParam("memberId") String memberId,
//                       @RequestParam("memberPass") String memberPass) {
//        System.out.println("memberId : " + memberId + ", memberPass : " + memberPass);
//        return "login";
//    }
//
//    @GetMapping("/choice")
//    public String choice() {return "choice";}
//}
