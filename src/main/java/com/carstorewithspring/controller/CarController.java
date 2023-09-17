package com.carstorewithspring.controller;

import com.carstorewithspring.data.mapper.CarMapper;
import com.carstorewithspring.data.request.CarRequest;
import com.carstorewithspring.data.response.CarResponse;
import com.carstorewithspring.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse create(@Valid @RequestBody CarRequest request){
        return CarMapper.toResponse(service.create(request));
    }

    @GetMapping
    public List<CarResponse> findAll(){
        return CarMapper.toResponse(service.findAll());
    }
}
