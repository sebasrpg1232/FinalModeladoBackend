package com.example.demo.domain.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class manager {
    private final String name;
    private final int age;
    private final LocalDate birthdate;

    public manager(String name, int age, LocalDate birthdate) {
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
