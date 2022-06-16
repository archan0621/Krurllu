package kr.co.archan.krullu.entity;

import kr.co.archan.krullu.dto.UserDto;
import kr.co.archan.krullu.extension.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
@Table(name = "member")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public static UserEntity createMember(UserDto userDto, PasswordEncoder passwordEncoder){

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userEntity.getUsername());
        userEntity.setNickname(userEntity.getNickname());
        userEntity.setEmail(userEntity.getEmail());
        String password = passwordEncoder.encode(userDto.getPassword());
        userEntity.setPassword(password);
        userEntity.setRole(Role.USER);
        return userEntity;
    }

}


