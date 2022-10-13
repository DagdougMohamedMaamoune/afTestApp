package com.example.aftest;

import com.example.aftest.domain.User;
import com.example.aftest.enums.GenderEnum;
import com.example.aftest.repository.UserRepository;
import com.example.aftest.service.UserService;
import com.example.aftest.web.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AfTestApplicationTests {

    @Mock
    private UserRepository userRepositoryMock;
    @InjectMocks
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindUserByParams() {
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto());
        when(userRepositoryMock.findUsersByParams(any(), any(), any())).thenReturn(Optional.of(users));
        List<UserDto> result = userService.findUserByParams(any(), any(), any());
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testFindUserByParamsWhenNoUser() {
        when(userRepositoryMock.findUsersByParams(any(), any(), any())).thenReturn(Optional.empty());
        List<UserDto> result = userService.findUserByParams(any(), any(), any());
        assertNotNull(result);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testSaveUser() {
        User user = new User("Test", new Date(), "test", "12345", GenderEnum.MALE);
        User savedUser = userRepository.save(user);
        User dbUser = userRepository.findById(savedUser.getId()).get();
        assertNotNull(dbUser);
        assertEquals(dbUser.getUserName(), user.getUserName());
    }

}
