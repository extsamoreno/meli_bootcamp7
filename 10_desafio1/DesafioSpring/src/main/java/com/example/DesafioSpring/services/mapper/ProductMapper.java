package com.example.DesafioSpring.services.mapper;

import com.example.DesafioSpring.dto.ProductDTO;
import com.example.DesafioSpring.models.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getId(),product.getName(), product.getType(), product.getColor(), product.getNotes());
    }
    public static Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getType(), productDTO.getColor(), productDTO.getNotes());
    }
}
