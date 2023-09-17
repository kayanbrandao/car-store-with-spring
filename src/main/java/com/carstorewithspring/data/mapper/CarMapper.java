package com.carstorewithspring.data.mapper;

import com.carstorewithspring.data.model.Car;
import com.carstorewithspring.data.response.CarResponse;

import java.util.ArrayList;
import java.util.List;

public class CarMapper {
    public static CarResponse toResponse(Car car){
        return new CarResponse(
                car.getId(),
                car.getColor(),
                car.getVersion(),
                car.getGearbox(),
                car.getYear(),
                car.getModel()
        );
    }

    public static List<CarResponse> toResponse(List<Car> cars){
        List<CarResponse> carResponses = new ArrayList<>();

        for (Car car : cars) {
            carResponses.add(new CarResponse(
                    car.getId(),
                    car.getColor(),
                    car.getVersion(),
                    car.getGearbox(),
                    car.getYear(),
                    car.getModel()
            ));
        }

        return carResponses;
    }
}
