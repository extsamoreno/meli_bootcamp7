package com.example.demo.project.service.mapper;

import com.example.demo.project.models.Product;
import com.example.demo.project.service.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getName(), product.getStock());
    }

    public static Product toProduct(ProductDTO product){
        return new Product(product.getName(), product.getStock());
    }
}
