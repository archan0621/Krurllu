package kr.co.archan.krullu.dto;

import kr.co.archan.krullu.extension.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class UserDto {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private Role role;

}
