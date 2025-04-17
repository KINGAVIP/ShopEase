package com.shopease.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopease.backend.model.Product;

//this repo handles Product entities and their id is of type int
//now we dont require any SQL for crud operations
public interface ProductRepository extends JpaRepository<Product,Integer>{
    
}
