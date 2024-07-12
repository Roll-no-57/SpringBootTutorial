package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


// This class is used to populate the database with some initial data

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "apurbo",
                    "apurbo@gmail.com",
                    LocalDate.of(1999, 5, 3)
            );

            Student mariam2 = new Student(
                    "mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, 5, 5)

            );
            Student apurbo = new Student(
                    "apurbo",
                    "mariam@gmail.com",
                    LocalDate.of(2001, 12, 1)
            );
            repository.saveAll(
                    List.of(mariam2,mariam,apurbo)
            );

        };
    }
}
