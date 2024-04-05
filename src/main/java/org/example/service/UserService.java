package org.example.service;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String addUser(User user){
        if(!user.getLogin().isBlank() &&!user.getPassword().isBlank() && user.getLogin().length()>3 ){
repository.save(user);
            return "Added";
        }
        else return "Not Added";
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }
}
