package com.fatec.hello.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fatec.hello.entities.Product;
import com.fatec.hello.repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping    
    public List<Product> getProducts() {
        return repository.findAll();
    }

}
