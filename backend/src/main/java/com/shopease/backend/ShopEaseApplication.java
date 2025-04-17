package com.shopease.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ShopEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopEaseApplication.class, args);
	}

}
