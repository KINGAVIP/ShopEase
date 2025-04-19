package com.shopease.backend.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopease.backend.model.Product;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductTestController {
    @Autowired 
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateProduct() throws Exception{
        Product product = new Product();
        product.setName("Paste");
        product.setCategory("items");
        product.setDescription("For cleaning teeth");
        product.setPrice(100.00);
        product.setQuantity(10L);
        mockMvc.perform(post("/api/test/add")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(product))
    
        ).andExpect(status()
        .isCreated());

    }
    @Test
public void testGetAllProducts() throws Exception {
    mockMvc.perform(get("/api/test/products"))
            .andExpect(status().isOk());
}
    @Test
    public void testGetProduct() throws Exception{
        System.out.println("Lets check output byt avi");
        mockMvc.perform(get("/api/test/product/2")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testDeleteProduct() throws Exception{
        mockMvc.perform(delete("/api/test/delete/4")).andExpect(status().isOk());
    }

    @Test
    public void testupdateProduct() throws Exception{
        mockMvc.perform(put("/api/test/update/2")).andExpect(status().isOk());  
    }

}
