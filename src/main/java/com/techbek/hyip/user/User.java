package com.techbek.hyip.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @UniqueUsername
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;


    @OneToOne(cascade = CascadeType.REMOVE)
    private PersonalDetails personalDetails;

    private String pin;

    private boolean isVerified;
}
