package com.example.aftest.web.dto;

import com.example.aftest.domain.User;
import com.example.aftest.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String userName;
    private Date birthDate;
    private String countryResidence;
    private String phoneNumber;
    private String gender;

    public UserDto(long id,
                   String userName,
                   Date birthDate,
                   String countryResidence,
                   String phoneNumber,
                   GenderEnum genderEnum) {
        setId(id);
        setUserName(userName);
        setBirthDate(birthDate);
        setCountryResidence(countryResidence);
        setPhoneNumber(phoneNumber);
        setGender(genderEnum != null ? genderEnum.name() : null);
    }

    public User toEntity() {
        User user = new User();
        user.setUserName(getUserName());
        user.setBirthDate(getBirthDate());
        user.setCountryResidence(getCountryResidence());
        user.setGender(getGender());
        user.setPhoneNumber(getPhoneNumber());
        return user;
    }

    public GenderEnum getGender() {
        if (gender == null || gender.isEmpty())
            return null;
        if (gender.equalsIgnoreCase("male"))
            return GenderEnum.MALE;
        if (gender.equalsIgnoreCase("female"))
            return GenderEnum.FEMALE;
        return GenderEnum.OTHER;
    }
}
