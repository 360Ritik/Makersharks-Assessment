package com.example.Makersharks;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Makersharks API Documentation",
                version = "1.0",
                description = "This is the API documentation for the Makersharks application."
        )
)
public class MakersharksApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakersharksApplication.class, args);
    }

}
