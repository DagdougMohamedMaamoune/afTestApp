package com.example.aftest.web.controller;


import com.example.aftest.service.UserService;
import com.example.aftest.utils.AgeUtils;
import com.example.aftest.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        if (userDto.getUserName() == null || userDto.getUserName().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserName is required !");
        if (userDto.getBirthDate() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BirthDate is required !");
        Date currDate = new Date();
        if (userDto.getBirthDate().compareTo(currDate) > 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BirthDate is not correct!");
        if (userDto.getCountryResidence() == null || userDto.getCountryResidence().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Country of Residence is required !");
        int userAge = AgeUtils.calculateAge(userDto.getBirthDate(), currDate);
        if (userAge < 18 || !userDto.getCountryResidence().equalsIgnoreCase("French"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only adult French residents are allowed to create an account!");
        long savedUserId = userService.saveUser(userDto).getId();
        return ResponseEntity.status(HttpStatus.OK).body(savedUserId);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailUser(@PathVariable long id) {
        UserDto userDto = userService.findUser(id);
        if (userDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + id + " is not registred");
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @GetMapping("/details")
    public ResponseEntity<?> detailUsers(@RequestParam(required = false) String userName,
                                         @RequestParam(required = false) Date birthDate,
                                         @RequestParam(required = false) String countryResidence) {
        List<UserDto> userDtos = userService.findUserByParams(userName, birthDate, countryResidence);
        if (userDtos.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not registred");
        return ResponseEntity.status(HttpStatus.OK).body(userDtos);
    }
}
