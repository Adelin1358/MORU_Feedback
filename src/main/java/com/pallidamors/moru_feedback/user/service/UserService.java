package com.pallidamors.moru_feedback.user.service;

import com.pallidamors.moru_feedback.common.MD5HashingEncoder;
import com.pallidamors.moru_feedback.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //final : 한번 값이 저장되면 다른 값이 지정 X
    private final UserRepository userRepository;

    //다른 생성자가 없이 Autowired를 위한 생성자만 있는 경우 @Autowired 생략가능
    //@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(
            String loginId
            , String password
            , String name
            , String email) {

        String encodePassword = MD5HashingEncoder.encode(password);

        int count = userRepository.insertUser(loginId, encodePassword, name, email);

        if (count == 1) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isDuplicate(String loginId){
        int count = userRepository.selectCountByLoginId(loginId);

        if(count == 0){
            return false;
        }else{
            return true;
        }
    }

}
