package kr.co.archan.krullu.servicetest;

import kr.co.archan.krullu.dto.UserDto;
import kr.co.archan.krullu.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kr.co.archan.krullu.service.UserService;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    UserService userService;

//    @Autowired
    PasswordEncoder passwordEncoder;

    public UserEntity createUser(){
        UserDto userDto = new UserDto();
        userDto.setEmail("test@gmail.com");
        userDto.setUsername("test");
        userDto.setNickname("test");
        userDto.setPassword("test_01");
        return UserEntity.createMember(userDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest(){
        UserEntity userEntity = createUser();

        UserEntity savedUser = userService.saveUser(userEntity);

        assertEquals(userEntity.getEmail(), savedUser.getEmail());
        assertEquals(userEntity.getUsername(), savedUser.getUsername());
        assertEquals(userEntity.getNickname(), savedUser.getNickname());
        assertEquals(userEntity.getPassword(), userEntity.getPassword());
        assertEquals(userEntity.getRole(), savedUser.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateUser(){
        UserEntity userEntity1 = createUser();
        UserEntity userEntity2 = createUser();
        userService.saveUser(userEntity1);

        Throwable e = assertThrows(IllegalStateException.class, () -> {
            userService.saveUser(userEntity2);
        });
        assertEquals("이미 가입된 회원입니다.", e.getMessage());
    }

}
