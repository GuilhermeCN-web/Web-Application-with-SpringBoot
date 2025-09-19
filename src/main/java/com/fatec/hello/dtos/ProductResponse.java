package com.fatec.hello.dtos;

import java.util.Map;

public record ProductResponse(
        Long id,
        String name,
        Double price
) {

    public Map<String, ?> getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
    
}