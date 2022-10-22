package com.example.demo.domain.driver;

import static com.example.demo.validation.DriverValidations.ValidateDriver;
import static java.time.LocalDate.parse;

public class Driver {
    private final String name;
    private final String email;
    private final float number;
    private final float Id;
    private final String address;

    public Driver(String name, String email, String number, String id, String address) {
        ValidateDriver(name, email, number, id, address);
        this.name = name;
        this.email = email;
        this.number = Float.parseFloat(number);
        Id = Float.parseFloat(id);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getNumber() {
        return number;
    }

    public float getId() {
        return Id;
    }

    public String getAddress() {
        return address;
    }
}