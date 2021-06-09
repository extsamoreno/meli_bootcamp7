package com.springChallenge.api.service.mapper.product;

import com.springChallenge.api.controller.dto.product.ProductDTO;
import com.springChallenge.api.repository.entity.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static Product toEntity(ProductDTO dto){
        return new Product(
                dto.getProductId(),
                dto.getProductName(),
                dto.getType(),
                dto.getBrand(),
                dto.getColor(),
                dto.getNotes());
    }
}
