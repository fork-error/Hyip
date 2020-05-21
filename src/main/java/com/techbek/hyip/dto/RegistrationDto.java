package com.techbek.hyip.dto;

import com.techbek.hyip.user.UniqueUsername;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class RegistrationDto {

    private String referral;

    @UniqueUsername
    @NotEmpty
    private String username;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty(message = "Password cannot be empty ")
    @Size(min =6, max = 30, message = "Password length must be between 6 and 30 ")
    private String password;

    @NotEmpty
    @Size(min = 4, max = 4, message = "PIN must be 4 digits")
    private String pin;

    private String country;
    private String firstName;
    private String lastName;


}
