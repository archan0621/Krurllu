package kr.co.archan.krullu.controller;

import kr.co.archan.krullu.entity.MemberEntity;
import kr.co.archan.krullu.service.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public Response signUpUser(@RequestBody MemberEntity memberEntity){
        Response response = new Response();

        try{
            authService.signUpUser(memberEntity);
            response.setStatus(0);
            response.setMessage("회원가입을 성공적으로 완료했습니다.");
        }
        catch (Exception e){
            response.setStatus(1);
            response.setMessage("회원가입을 하는 도중 오류가 발생했습니다.");
            response.setErrorException(e);
        }

        return response;
    }

}
