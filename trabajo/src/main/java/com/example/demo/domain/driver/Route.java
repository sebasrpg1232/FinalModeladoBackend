package com.example.demo.domain.driver;

import java.util.UUID;

public class Route {
    private final int hours;
    private final UUID busSerial;

    public Route(int hours, UUID busSerial) {
        this.hours = hours;
        this.busSerial = busSerial;
    }
}
