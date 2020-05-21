package com.techbek.hyip.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private String firstName;
    private String lastName;
    private String country;
}
