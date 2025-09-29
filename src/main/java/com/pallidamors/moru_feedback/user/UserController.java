package com.pallidamors.moru_feedback.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/join")
    public String joinForm(){
        return "user/join";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }
}
