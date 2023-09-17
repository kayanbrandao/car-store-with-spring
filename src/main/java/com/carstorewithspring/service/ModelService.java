package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.ModelDto;
import com.carstorewithspring.data.model.Model;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.ModelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    private final ModelRepository repository;

    @Autowired
    public ModelService(ModelRepository repository) {
        this.repository = repository;
    }

    public Model create(ModelDto request){
        Model model = new Model();
        BeanUtils.copyProperties(request, model);
        return repository.save(new Model(
                request.name(),
                request.brand()
        ));
    }

    public List<Model> findAll(){
        return repository.findAll();
    }

    public Model findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    public Model update(ModelDto request){
        Model model = repository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));

        model.setName(request.name());
        model.setBrand(request.brand());

        return repository.save(model);
    }

    public void delete(Long id){
        Model model = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
        repository.delete(model);
    }
}
