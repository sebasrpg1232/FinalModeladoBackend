package com.example.demo.domain.secretary;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class secretary {
    private final String name;
    private final int age;
    private final LocalDate birthdate;

    public secretary(String name, int age, LocalDate birthdate) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
