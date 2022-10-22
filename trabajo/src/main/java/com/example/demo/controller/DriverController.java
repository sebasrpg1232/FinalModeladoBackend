package com.example.demo.controller;

import com.example.demo.domain.driver.Driver;

import com.example.demo.repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {
    private DriverRepository repository;

    public DriverController(DriverRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Driver> listDriver(){
        return repository.list();
    }

    @PostMapping
    public Driver createADriver(
            @RequestBody Driver driver
    ){
        repository.create(driver);
        return driver;
    }

    @GetMapping(value="/{id}")
    public Driver getById(
            @PathVariable("id")String driverId
    ){
        return repository.getter(driverId);
    }

    @DeleteMapping(value="/{id}")
    public Driver delete(
            @PathVariable("id")String driverId
    ){
        Driver productFound = repository.getter(driverId);
        repository.delete(driverId);
        return productFound;
    }

    @PutMapping(value = "id")
    public Driver updateDriver(
            @PathVariable("id") String driverId,
            @RequestBody Driver driver
    ){
        repository.update(driverId, driver);
        return repository.getter(driverId);
    }
}
