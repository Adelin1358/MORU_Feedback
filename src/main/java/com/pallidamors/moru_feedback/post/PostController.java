package com.pallidamors.moru_feedback.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {


    @GetMapping("/main-page")
    public String mainPage() {
        return "post/main-page";

    }
}
