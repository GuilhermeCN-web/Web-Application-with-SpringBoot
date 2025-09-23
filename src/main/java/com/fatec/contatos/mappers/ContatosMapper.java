package com.fatec.contatos.mappers;

import com.fatec.contatos.dtos.ContatosRequest;
import com.fatec.contatos.dtos.ContatosResponse;
import com.fatec.contatos.entities.Contatos;

public class ContatosMapper {
    
    public static Contatos toEntity(ContatosRequest request) {
        Contatos p = new Contatos();
        p.setName(request.name());
        return p;
    }

    public static ContatosResponse toDTO(Contatos product) {
         return new ContatosResponse(
            product.getId(),
            product.getName(),
            product.getEmail(),
            product.getPhoneNumber(),
            product.getAddress(),
            product.getAge()
         );
    }
}