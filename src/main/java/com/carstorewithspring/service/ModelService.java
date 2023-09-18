package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.ModelDto;
import com.carstorewithspring.data.entity.Model;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.ModelRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelService {
    private final ModelRepository repository;

    @Autowired
    public ModelService(ModelRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Model create(ModelDto request){
        Model model = new Model();
        BeanUtils.copyProperties(request, model);
        return repository.save(new Model(
                request.name(),
                request.brand()
        ));
    }

    @Transactional(readOnly = true)
    public List<Model> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Model findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    @Transactional
    public Model update(ModelDto request){
        Model model = findById(request.id());

        model.setName(request.name());
        model.setBrand(request.brand());

        return repository.save(model);
    }

    @Transactional
    public void delete(Long id){
        Model model = findById(id);
        repository.delete(model);
    }
}
