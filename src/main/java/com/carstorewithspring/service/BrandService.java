package com.carstorewithspring.service;

import com.carstorewithspring.data.api.BrandRequest;
import com.carstorewithspring.data.api.BrandResponse;
import com.carstorewithspring.data.model.Brand;
import com.carstorewithspring.repository.BrandRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository repository;

    @Autowired
    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public Brand create(BrandRequest request){
        Brand brand = new Brand();
        BeanUtils.copyProperties(request, brand);
        return repository.save(brand);
    }

    public List<Brand> findAll(){
        return repository.findAll();
    }
}
