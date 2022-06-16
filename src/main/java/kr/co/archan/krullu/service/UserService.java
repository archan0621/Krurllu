package kr.co.archan.krullu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.archan.krullu.jpaRepo.UserRepository;
import kr.co.archan.krullu.entity.UserEntity;
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity){
        validateDupliateUser(userEntity);
        return userRepository.save(userEntity);
    }

    private void validateDupliateUser(UserEntity userEntity) {
        UserEntity findUser = userRepository.findByEmail(userEntity.getEmail());
        if (findUser != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
