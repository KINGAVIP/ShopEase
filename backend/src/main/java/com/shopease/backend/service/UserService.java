package com.shopease.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopease.backend.model.User;
import com.shopease.backend.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id)
    {
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
    }

    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }

    public User createUser(User u)
    {
        return userRepository.save(u);
    }

    public User updateUser(int id , User a)
    {
        User u = userRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        u.setUsername(a.getUsername());
        u.setPassword(a.getPassword());
        u.setRole(a.getRole());
        return userRepository.saveAndFlush(u);
    }

    public boolean authenticate(String username, String password){
        User u =userRepository.findByUsername(username);
        if(u!=null && u.getPassword().equals(password))
            return true;
        return false;
    }


    


    
}
