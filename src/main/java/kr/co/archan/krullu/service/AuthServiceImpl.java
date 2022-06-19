package kr.co.archan.krullu.service;

import kr.co.archan.krullu.entity.MemberEntity;
import kr.co.archan.krullu.extension.Salt;
import kr.co.archan.krullu.extension.SaltUtil;
import kr.co.archan.krullu.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private SaltUtil saltUtil;

    @Override
    public void signUpUser(MemberEntity memberEntity){
        String password = memberEntity.getPassword();
        String salt = saltUtil.genSalt();
        memberEntity.setSalt(new Salt(salt));
        memberEntity.setPassword(saltUtil.encodePassword(salt,password));
        memberRepository.save(memberEntity);
    }

    @Override
    public MemberEntity loginUser(String id, String password) throws Exception{
        MemberEntity memberEntity = memberRepository.findByUsername(id);
        if(memberEntity == null) throw new Exception("멤버가 조회되지 않음");
        String salt = memberEntity.getSalt().getSalt();
        password = saltUtil.encodePassword(salt,password);
        if(!memberEntity.getPassword().equals(password)) {
            throw new Exception("비밀번호가 틀립니다.");
        }
        return memberEntity;
    }

}
