package com.carstorewithspring.service;

import com.carstorewithspring.data.request.ModelRequest;
import com.carstorewithspring.data.model.Model;
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

    public Model create(ModelRequest request){
        Model model = new Model();
        BeanUtils.copyProperties(request, model);
        return repository.save(model);
    }

    public List<Model> findAll(){
        return repository.findAll();
    }
}
