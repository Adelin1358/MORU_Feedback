package com.pallidamors.moru_feedback.user;

import com.pallidamors.moru_feedback.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController // @Controller + @ResponseBody
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //회원 가입 API
    @PostMapping("/join-process")
    public Map<String, String> join(
            @RequestParam String loginId
            , @RequestParam String password
            , @RequestParam String name
            , @RequestParam String email){

        Map<String, String> resultMap = new HashMap<>();

        if(userService.createUser(loginId, password, name, email)){
            resultMap.put("result", "success");
        }else{
            resultMap.put("result", "false");
        }
        return resultMap;
    }

    @GetMapping("/duplicate-id")
    public Map<String, Boolean> isDuplicate(@RequestParam String loginId){

        Map<String, Boolean> resultMap = new HashMap<>();

        if(userService.isDuplicate(loginId)){
            resultMap.put("isDuplicate", true);
        } else{
            resultMap.put("isDuplicate", false);
        }

        return resultMap;
    }
}
