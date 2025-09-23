package com.fatec.contatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.contatos.entities.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {
    
}
