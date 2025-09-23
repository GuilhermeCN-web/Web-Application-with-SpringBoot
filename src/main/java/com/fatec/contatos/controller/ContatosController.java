package com.fatec.contatos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.contatos.dtos.ContatosRequest;
import com.fatec.contatos.dtos.ContatosResponse;
import com.fatec.contatos.services.ContatosService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("products")
public class ContatosController {

    @Autowired
    private ContatosService service;

    @GetMapping    
    public ResponseEntity<List<ContatosResponse>> getProducts() {
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<ContatosResponse> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable long id) {
        service.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ContatosResponse> saveProduct(@Valid @RequestBody ContatosRequest request)
    {
        ContatosResponse newProduct = service.saveProduct(request);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newProduct.id())
            .toUri();
        return ResponseEntity.created(location).body(newProduct);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @Valid @RequestBody ContatosRequest request)
    {
        service.updateProduct(request, id);
        return ResponseEntity.noContent().build();
    }
}
