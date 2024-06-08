package com.exam.nikolozmelashvili.entities.dto;

import com.exam.nikolozmelashvili.entities.model.CarServices;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private String make;

    private String model;

    private int year;

    private String licensePlate;

    private CarServices service;
}
