package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.dto.CarDTO;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarMapper;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void insertCar(CarDTO car) {
        Car carEntity = CarMapper.dtoToEntity(car);
        carRepository.save(carEntity);
    }
}
