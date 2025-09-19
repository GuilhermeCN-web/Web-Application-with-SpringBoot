package com.fatec.hello.mappers;

import com.fatec.hello.dtos.ProductRequest;
import com.fatec.hello.dtos.ProductResponse;
import com.fatec.hello.entities.Product;

public class ProductMapper {
    
    public static Product toEntity(ProductRequest request) {
        Product p = new Product();
        p.setName(request.name());
        p.setPrice(request.price());
        return p;
    }

    public static ProductResponse toDTO(Product product) {
         return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice()
         );
    }
}