package kr.co.archan.krullu.dto;

import lombok.*;

import kr.co.archan.krullu.entity.userEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private userEntity.Role role;

    public userEntity toEntity() {
        userEntity ue = userEntity.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(userEntity.Role.USER)
                .build();

        return ue;
    }
}
