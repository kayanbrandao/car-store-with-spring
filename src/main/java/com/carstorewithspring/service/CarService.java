package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.CarDto;
import com.carstorewithspring.data.entity.Car;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {
    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Car create(CarDto request){
        return repository.save(new Car(
                request.color(),
                request.version(),
                request.gearbox(),
                request.year(),
                request.model()
        ));
    }

    @Transactional(readOnly = true)
    public List<Car> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Car findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    @Transactional
    public Car update(CarDto request){
        Car car = findById(request.id());

        car.setColor(request.color());
        car.setVersion(request.version());
        car.setGearbox(request.gearbox());
        car.setModel(request.model());

        return repository.save(car);
    }

    @Transactional
    public void delete(Long id){
        Car car = findById(id);
        repository.delete(car);
    }
}
