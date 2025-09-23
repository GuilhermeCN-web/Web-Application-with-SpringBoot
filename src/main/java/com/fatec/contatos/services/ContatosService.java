package com.fatec.contatos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.contatos.dtos.ContatosRequest;
import com.fatec.contatos.dtos.ContatosResponse;
import com.fatec.contatos.entities.Contatos;
import com.fatec.contatos.mappers.ContatosMapper;
import com.fatec.contatos.repositories.ContatosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

     public List<ContatosResponse> getProducts() {
        return repository.findAll()
                .stream()
                .map(ContatosMapper::toDTO)
                .toList();
    }

    public ContatosResponse getProductById(long id) {
        return repository.findById(id)
                .map(ContatosMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Contato não cadastrado"));
    }
    
     public ContatosResponse saveProduct(ContatosRequest request) {
        Contatos product = ContatosMapper.toEntity(request);
        Contatos savedProduct = repository.save(product);
        return ContatosMapper.toDTO(savedProduct);
    }

    public void deleteProductById(long id) {
		if(repository.existsById(id))
			repository.deleteById(id);
		else
			throw new EntityNotFoundException("Contato não existe");
    }

    public void updateProduct(ContatosRequest request, long id){
        Contatos aux = repository.getReferenceById(id);
        aux.setName(request.name());
        aux.setEmail(request.email());

        repository.save(aux);
    }
}