package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.ProductDTO;
import com.meli.desafio1.web.model.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getProduct_id(),product.getProductName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }
    public static Product toModel(ProductDTO product){
        return new Product(product.getProduct_id(),product.getProductName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }
}
