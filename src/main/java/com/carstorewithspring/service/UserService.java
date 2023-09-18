package com.carstorewithspring.service;

import com.carstorewithspring.data.dto.UserDto;
import com.carstorewithspring.data.entity.User;
import com.carstorewithspring.exception.ResourceNotFoundException;
import com.carstorewithspring.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public User create(UserDto request){
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return repository.save(new User(
                request.username(),
                request.password(),
                request.role()
        ));
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado esse id!"));
    }

    @Transactional
    public User update(UserDto request){
        User user = findById(request.id());

        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setRole(request.role());

        return repository.save(user);
    }

    @Transactional
    public void delete(Long id){
        User user = findById(id);
        repository.delete(user);
    }
}
