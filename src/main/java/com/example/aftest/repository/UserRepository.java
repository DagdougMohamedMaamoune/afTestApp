package com.example.aftest.repository;

import com.example.aftest.domain.User;
import com.example.aftest.web.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select new com.example.aftest.web.dto.UserDto(" +
            "u.id," +
            "u.userName," +
            "u.birthDate," +
            "u.countryResidence," +
            "u.phoneNumber," +
            "u.gender" +
            ") from User u " +
            "where u.id = :id")
    Optional<UserDto> findUserById(@Param("id") long id);

    @Query(value = "select new com.example.aftest.web.dto.UserDto(" +
            "u.id," +
            "u.userName," +
            "u.birthDate," +
            "u.countryResidence," +
            "u.phoneNumber," +
            "u.gender" +
            ") from User u " +
            "where (u.userName like :userName or '' = :userName or :userName is null) " +
            "and (u.birthDate = :birthDate or :birthDate is null) " +
            "and (u.countryResidence = :countryResidence or '' = :countryResidence or :countryResidence is null) ")
    Optional<List<UserDto>> findUsersByParams(@Param("userName") String userName,
                                              @Param("birthDate") Date birthDate,
                                              @Param("countryResidence") String countryResidence);
}
