package com.shopease.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopease.backend.model.Product;
import com.shopease.backend.service.ProductService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    
    @GetMapping("/product/{id}")
    public Optional<Product> getProductbyId(@PathVariable int id) {
        System.out.println(productService.getProduct(id));
        return productService.getProduct(id);
    }

    // @PutMapping("/update/{id}")
    // public Product updateProduct(@PathVariable String id, @RequestBody String entity) {
    //     //TODO: process PUT request
    //     productService.update
    // }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id) throws Exception{
        //TODO: process PUT request
        Product p= new Product();
        p.setName("yoyo");
        p.setPrice(10.00);
        return productService.updateProduct(id, p);
    }

    
    


    
}
