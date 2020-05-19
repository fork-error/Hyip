package com.techbek.hyip.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {
    @NotEmpty
    @Email(message = "Invalid email address format")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    private String password;
}
