package com.shopease.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopease.backend.model.User;
import com.shopease.backend.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/find/{id}")
    public User getUser(@PathVariable int id){return userService.getUserById(id);}
    
    @PostMapping("/create")
    public User createUser(@RequestBody User u) {
        return userService.createUser(u);        
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User u) {
        return userService.updateUser(id, u);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id )
    {
        userService.deleteUser(id);
    }
}
