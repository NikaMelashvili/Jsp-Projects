package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.model.Car;

public class CarMapper {

    public static Car dtoToEntity(CarDTO carDTO) {
        Car car = new Car();

        car.setMake(carDTO.getMake());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setService(carDTO.getService());

        return car;
    }

    public static CarDTO entityToDto(Car car) {
        CarDTO carDTO = new CarDTO();

        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());
        carDTO.setLicensePlate(car.getLicensePlate());
        carDTO.setService(car.getService());

        return carDTO;
    }

}
