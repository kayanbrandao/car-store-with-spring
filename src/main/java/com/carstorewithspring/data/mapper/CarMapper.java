package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.dto.CarDto;
import com.carstorewithspring.data.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {
    public static CarDto toResponse(Car car){
        return new CarDto(
                car.getId(),
                car.getColor(),
                car.getVersion(),
                car.getGearbox(),
                car.getYear(),
                car.getModel()
        );
    }

    public static List<CarDto> toResponse(List<Car> cars){
        List<CarDto> CarDto = new ArrayList<>();

        for (Car car : cars) {
            CarDto.add(new CarDto(
                    car.getId(),
                    car.getColor(),
                    car.getVersion(),
                    car.getGearbox(),
                    car.getYear(),
                    car.getModel()
            ));
        }

        return CarDto;
    }
}
