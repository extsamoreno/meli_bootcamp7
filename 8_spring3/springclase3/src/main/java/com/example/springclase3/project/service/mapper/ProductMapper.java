package com.example.springclase3.project.service.mapper;

import com.example.springclase3.project.repository.Product;
import com.example.springclase3.project.service.dto.ProductDTO;


public class ProductMapper {

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getName(), product.getStock());
    }

    public static ProductDTO toProduct(Product product){
        return new ProductDTO(product.getName(), product.getStock());
    }
}
