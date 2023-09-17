package com.carstorewithspring.service;

import com.carstorewithspring.data.model.Car;
import com.carstorewithspring.data.model.Model;
import com.carstorewithspring.data.request.CarRequest;
import com.carstorewithspring.data.request.ModelRequest;
import com.carstorewithspring.repository.CarRepository;
import com.carstorewithspring.repository.ModelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public Car create(CarRequest request){
        Car car = new Car();
        BeanUtils.copyProperties(request, car);
        return repository.save(car);
    }

    public List<Car> findAll(){
        return repository.findAll();
    }
}
