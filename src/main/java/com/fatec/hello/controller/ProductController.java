package com.fatec.hello.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fatec.hello.entities.Product;
import com.fatec.hello.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping    
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable long id) {
        return service.getProductById(id);
    }
}
