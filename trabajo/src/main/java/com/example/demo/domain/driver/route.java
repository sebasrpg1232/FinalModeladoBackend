package com.example.demo.domain.driver;

import java.util.UUID;

public class route {
    private final int hours;
    private final UUID busSerial;

    public route(int hours, UUID busSerial) {
        this.hours = hours;
        this.busSerial = busSerial;
    }
}
