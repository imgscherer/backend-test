package com.example.ormabackendtest.services;

import com.example.ormabackendtest.entities.User;
import com.example.ormabackendtest.repositories.UserRepository;
import com.example.ormabackendtest.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findByToken(Long token){
        return repository.findByToken(token);
    }

    public User insert(User obj) {
        obj.setToken(tokenGenerator());
        obj.setPoints(1L);
        return repository.save(obj);
    }

    public User update (Long token, User obj) {
        try {
            User entity = repository.findByToken(token);
            updatePoints(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(token);
        }
    }

    private void updatePoints(User entity, User obj) {
        entity.setPoints(obj.getPoints()+1);
    }

    public Long tokenGenerator(){
        long min = 10000000L;
        long max = 99999999L;
        return (long)(Math.random() * ((max - min) + 1)) + min;
    }



}
