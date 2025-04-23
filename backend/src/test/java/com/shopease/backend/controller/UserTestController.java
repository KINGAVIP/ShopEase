package com.shopease.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopease.backend.model.User;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTestController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUser() throws Exception
    {
        User u=new User();
        u.setUsername("rohit");
        u.setPassword("kin12");
        u.setRole("Admin");
        mockMvc.perform(post("/user/create").contentType("application/json")
        .content(objectMapper.writeValueAsString(u))).andExpect(status().isCreated());
    }

    @Test
    public void getUsers() throws Exception{
        mockMvc.perform(get("/user/all")).andExpect(status().isOk());
    }
    
    @Test
    public void getUser() throws Exception{
        mockMvc.perform(get("/user/find/1")).andExpect(status().isOk());
    }
    
    @Test
    public void deleteUser() throws Exception{
        mockMvc.perform(delete("/user/delete/1")).andExpect(status().isOk());
    }

    @Test
    public void updateUser() throws Exception{
        User u=new User();
        u.setRole("User");
        mockMvc.perform(put("/user/update/2").contentType("application/json").content(objectMapper.writeValueAsString(u))).andExpect(status().isOk());
    }

    


    
}
