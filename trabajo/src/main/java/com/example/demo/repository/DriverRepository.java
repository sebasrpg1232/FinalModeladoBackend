package com.example.demo.repository;

import com.example.demo.domain.driver.Driver;

import java.util.List;

public interface DriverRepository {
    List<Driver> list();


    Driver getter(String id);

    void create(Driver product);

    void update(String id, Driver driver);

    void delete(String id);
}