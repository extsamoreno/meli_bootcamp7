package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.models.Product;

public class ProductMapper {
    private static ProductResponseDTO toDTO(Product product){
        return null;
    }
    private static Product toModel(ProductRequestDTO product){
        return new Product();
    }
}
