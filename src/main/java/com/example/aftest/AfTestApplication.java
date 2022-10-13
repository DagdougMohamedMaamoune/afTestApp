package com.example.aftest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Users API", version = "2.0", description = "User Information"))
public class AfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfTestApplication.class, args);
    }

}
