package com.techbek.hyip.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String username;
    private String email;
    private String password;
    private String pin;
    private String country;
    private String firstName;
    private String lastName;


}
