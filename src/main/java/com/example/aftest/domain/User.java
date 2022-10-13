package com.example.aftest.domain;

import com.example.aftest.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "af_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

    @Column(name = "countryResidence", nullable = false)
    private String countryResidence;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    public User(String userName, Date birthDate, String countryResidence, String phoneNumber, GenderEnum gender) {
        this.userName = userName;
        this.birthDate = birthDate;
        this.countryResidence = countryResidence;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}
