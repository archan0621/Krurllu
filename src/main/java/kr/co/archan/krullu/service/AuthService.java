package kr.co.archan.krullu.service;

import kr.co.archan.krullu.entity.MemberEntity;

public interface AuthService {

    void signUpUser(MemberEntity memberEntity);

    MemberEntity loginUser(String id, String password) throws Exception;

}
