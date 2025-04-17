package com.shopease.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopease.backend.model.Product;
import com.shopease.backend.service.ProductService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

@RequestMapping("/api/test")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String hello()
    {
        return "hello avi";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        System.out.println("Here are products");
        return productService.getAllProducts();
        
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product p) {
        productService.addProduct(p);
        System.out.println("Added"+ p.getId());
    }
    
    
    


    
}
