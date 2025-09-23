package com.fatec.contatos.dtos;

import java.util.Map;

public record ContatosResponse(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String address,
        int age
) {

    public Map<String, ?> getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
    
}