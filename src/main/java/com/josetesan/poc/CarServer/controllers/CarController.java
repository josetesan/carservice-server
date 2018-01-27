package com.josetesan.poc.CarServer.controllers;

import com.josetesan.poc.CarServer.beans.Car;
import com.josetesan.poc.CarServer.beans.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
        return carRepository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());

    }

    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");

    }
}
