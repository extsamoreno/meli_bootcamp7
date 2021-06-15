package com.example.demo.project.mappers;

import com.example.demo.project.models.Product;
import com.example.demo.project.dtos.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getName(), product.getStock());
    }

    public static Product toProduct(ProductDTO product){
        return new Product(product.getName(), product.getStock());
    }
}
