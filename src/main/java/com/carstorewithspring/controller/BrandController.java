package com.carstorewithspring.controller;

import com.carstorewithspring.data.request.BrandRequest;
import com.carstorewithspring.data.response.BrandResponse;
import com.carstorewithspring.data.mapper.BrandMapper;
import com.carstorewithspring.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService service;

    @Autowired
    public BrandController(BrandService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponse create(@Valid @RequestBody BrandRequest request){
        return BrandMapper.toResponse(service.create(request));
    }

    @GetMapping
    public List<BrandResponse> findAll(){
        return BrandMapper.toResponse(service.findAll());
    }
}
