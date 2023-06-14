package com.ll.exam.final__2022_10_08.app.member.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class JoinForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    private String nickname;

}
