package com.example.demo.domain.driver;

import com.example.demo.validation.DriverValidations;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalDate.parse;

public class driver {
    private final String name;
    private final LocalDate birthdate;
    private final int age;
    private final String email;
    private final int number;
    private final Route driversRoute;

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    public Route getDriversRoute() {
        return driversRoute;
    }

    public driver(String name, String birthdate, String age, String email, String number, Route driversRoute) {
        DriverValidations.ValidateDriver(name, birthdate, age, email, number, driversRoute);
        this.name = name;
        this.birthdate = parse(birthdate);
        this.age = Integer.parseInt(age);
        this.email = email;
        this.number = Integer.parseInt(number);
        this.driversRoute = driversRoute;
    }

}
