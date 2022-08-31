package com.example.demo.domain.driver;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalDate.parse;

public class driver {
    private final String name;
    private final LocalDateTime birthdate;
    private final int age;
    private final String email;
    private final int number;
    private final route driversRoute;

    public driver(String name, LocalDateTime birthdate, int age, String email, int number, route driversRoute) {
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
        this.email = email;
        this.number = number;
        this.driversRoute = driversRoute;
    }

}
