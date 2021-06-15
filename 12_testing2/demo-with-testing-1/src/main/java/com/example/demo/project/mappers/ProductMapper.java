package com.example.demo.project.mappers;

import com.example.demo.project.models.Product;
import com.example.demo.project.dtos.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product){
        return new ProductDTO(product.getName(), product.getStock());
    }

    public Product toProduct(ProductDTO product){
        return new Product(product.getName(), product.getStock());
    }
}
