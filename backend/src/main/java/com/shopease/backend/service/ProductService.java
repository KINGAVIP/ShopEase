package com.shopease.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopease.backend.model.Product;
import com.shopease.backend.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product>getAllProducts(){
        return productRepository.findAll();
    }
    public Product addProduct(Product p)
    {
        return productRepository.save(p);
    }
    public Optional<Product> getProduct(int id)
    {
        return productRepository.findById(id);
    }
    public void deleteProduct(int id)
    {
        productRepository.deleteById(id);
    }

    public Product updateProduct(int id , Product pr)
    {
        Product p = productRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        p.setName(pr.getName());
        p.setPrice(pr.getPrice());
        return productRepository.saveAndFlush(p);
    }

}
