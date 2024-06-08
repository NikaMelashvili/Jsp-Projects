package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.CarServiceDTO;
import com.exam.nikolozmelashvili.entities.model.CarServices;

public class CarServiceMapper {

    public static CarServices dtoToEntity(CarServiceDTO serviceDTO) {
        CarServices service = new CarServices();

        service.setName(serviceDTO.getName());
        service.setDescription(serviceDTO.getDescription());
        service.setPrice(serviceDTO.getPrice());

        return service;
    }

    public static CarServiceDTO entityToDto(CarServices service) {
        CarServiceDTO serviceDTO = new CarServiceDTO();

        serviceDTO.setName(service.getName());
        serviceDTO.setDescription(service.getDescription());
        serviceDTO.setPrice(service.getPrice());

        return serviceDTO;
    }
}
