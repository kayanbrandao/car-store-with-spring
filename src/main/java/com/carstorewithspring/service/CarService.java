package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.CarDto;
import com.carstorewithspring.data.model.Car;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.CarRepository;
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

    public Car create(CarDto request){
        return repository.save(new Car(
                request.color(),
                request.version(),
                request.gearbox(),
                request.year(),
                request.model()
        ));
    }

    public List<Car> findAll(){
        return repository.findAll();
    }

    public Car findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    public Car update(CarDto request){
        Car car = repository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));

        car.setColor(request.color());
        car.setVersion(request.version());
        car.setGearbox(request.gearbox());
        car.setModel(request.model());

        return repository.save(car);
    }

    public void delete(Long id){
        Car car = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
        repository.delete(car);
    }
}
