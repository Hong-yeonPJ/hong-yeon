package com.hy.hongyeon.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.hy.hongyeon.member.entity.MemberRole;
import com.hy.hongyeon.member.entity.MemberType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberDto {
    @Size(min = 5, max = 25)
    @NotEmpty(message = "ID는 필수항목입니다.")
    private String username;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    @Size(min = 8, max = 16, message = "비밀번호는 8 과 16 자 사이어야 합니다.")
    private String password;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String passwordCheck;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    @NotEmpty(message = "휴대폰 번호는 필수항목입니다.")
    private String phoneNumber;

    @NotNull(message = "생년월일은 필수항목입니다.")
    private LocalDate birthday;

    private MemberType memberType; // Enum 타입
    private MemberRole memberRole; // Enum 타입
}
