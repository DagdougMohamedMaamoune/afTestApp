package com.example.aftest.service;

import com.example.aftest.domain.User;
import com.example.aftest.repository.UserRepository;
import com.example.aftest.web.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(UserDto userDto) {
        User userMapped = userDto.toEntity();
        return userRepository.save(userMapped);
    }

    public UserDto findUser(long id) {
        return userRepository.findUserById(id).orElse(null);
    }

    public List<UserDto> findUserByParams(String userName, Date birthDate, String countryResidence) {
        return userRepository.findUsersByParams(userName, birthDate, countryResidence).orElse(new ArrayList<>());
    }
}
