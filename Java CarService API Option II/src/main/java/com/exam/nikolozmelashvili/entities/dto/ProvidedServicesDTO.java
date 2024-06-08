package com.exam.nikolozmelashvili.entities.dto;

import com.exam.nikolozmelashvili.entities.model.Car;
import com.exam.nikolozmelashvili.entities.model.CarServices;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvidedServicesDTO {

    private Car car;

    private CarServices carServices;

    private double price;
}
