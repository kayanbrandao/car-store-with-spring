package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.BrandDto;
import com.carstorewithspring.data.entity.Brand;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository repository;

    @Autowired
    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Brand create(BrandDto request){
        return repository.save(new Brand(
                request.name()
        ));
    }

    @Transactional(readOnly = true)
    public List<Brand> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Brand findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    @Transactional
    public Brand update(BrandDto request){
        Brand brand = findById(request.id());

        brand.setName(request.name());

        return repository.save(brand);
    }

    @Transactional
    public void delete(Long id){
        Brand brand = findById(id);
        repository.delete(brand);
    }

}
