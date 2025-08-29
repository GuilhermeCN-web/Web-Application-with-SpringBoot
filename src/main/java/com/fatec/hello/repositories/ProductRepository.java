package com.fatec.hello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.hello.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
