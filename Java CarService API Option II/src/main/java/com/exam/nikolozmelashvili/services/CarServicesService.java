package com.exam.nikolozmelashvili.services;

import com.exam.nikolozmelashvili.entities.dto.CarServiceDTO;
import com.exam.nikolozmelashvili.entities.dto.mapper.CarServiceMapper;
import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;
import com.exam.nikolozmelashvili.repository.CarRepository;
import com.exam.nikolozmelashvili.repository.CarServiceRepository;
import com.exam.nikolozmelashvili.repository.ProvidedServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServicesService {

    private CarServiceRepository serviceRepository;

    private CarRepository carRepository;

    private ProvidedServicesRepository providedServicesRepository;

    @Autowired
    public void setServiceRepository(CarServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    public void setProvidedServicesRepository(ProvidedServicesRepository providedServicesRepository) {
        this.providedServicesRepository = providedServicesRepository;
    }

    public void insertService(CarServiceDTO service) {
        CarServices carServiceEntity = CarServiceMapper.dtoToEntity(service);
        serviceRepository.save(carServiceEntity);
    }

    public void getCarServiced(Long serviceId, Long carId) {
        Optional<Car> car = carRepository.findById(carId);
        Car carEntity = car.get();
        CarServices carServices = serviceRepository.findById(serviceId).get();
        carEntity.setService(carServices);

        carRepository.save(carEntity);

        ProvidedServices providedServices = new ProvidedServices();
        providedServices.setCar(carEntity);
        providedServices.setCarServices(carServices);
        providedServices.setPrice(carServices.getPrice());

        providedServicesRepository.save(providedServices);
    }

    public ProvidedServices getProvidedService(Long id) {
        Optional<ProvidedServices> providedServices = providedServicesRepository.findById(id);
        ProvidedServices service = providedServices.get();
        return service;
    }

    public Double getFullServicePrice() {

    }
}
