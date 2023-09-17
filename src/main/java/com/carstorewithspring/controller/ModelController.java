package com.carstorewithspring.controller;

import com.carstorewithspring.data.request.ModelRequest;
import com.carstorewithspring.data.response.ModelResponse;
import com.carstorewithspring.data.mapper.ModelMapper;
import com.carstorewithspring.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService service;

    @Autowired
    public ModelController(ModelService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModelResponse create(@Valid @RequestBody ModelRequest request){
        return ModelMapper.toResponse(service.create(request));
    }

    @GetMapping
    public List<ModelResponse> findAll(){
        return ModelMapper.toResponse(service.findAll());
    }
}
