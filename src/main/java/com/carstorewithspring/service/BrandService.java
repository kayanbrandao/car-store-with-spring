package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.BrandDto;
import com.carstorewithspring.data.model.Brand;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.BrandRepository;
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

    public Brand create(BrandDto request){
        return repository.save(new Brand(
                request.name()
        ));
    }

    public List<Brand> findAll(){
        return repository.findAll();
    }

    public Brand findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    public Brand update(BrandDto request){
        Brand brand = repository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));

        brand.setName(request.name());

        return repository.save(brand);
    }

    public void delete(Long id){
        Brand brand = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
        repository.delete(brand);
    }

}
