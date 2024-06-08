package com.exam.nikolozmelashvili.entities.dto.mapper;

import com.exam.nikolozmelashvili.entities.dto.ProvidedServicesDTO;
import com.exam.nikolozmelashvili.entities.model.ProvidedServices;

public class ProvidedServicesMapper {

    public static ProvidedServices dtoToEntity(ProvidedServices dto) {
        ProvidedServices entity = new ProvidedServices();

        entity.setCar(dto.getCar());
        entity.setCarServices(dto.getCarServices());
        entity.setPrice(dto.getPrice());

        return entity;
    }

    public static ProvidedServicesDTO entityToDto(ProvidedServices entity) {
        ProvidedServicesDTO dto = new ProvidedServicesDTO();

        dto.setCar(entity.getCar());
        dto.setCarServices(entity.getCarServices());
        dto.setPrice(entity.getPrice());

        return dto;
    }
}
