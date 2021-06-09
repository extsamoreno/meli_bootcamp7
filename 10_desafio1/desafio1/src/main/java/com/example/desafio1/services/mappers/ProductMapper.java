package com.example.desafio1.services.mappers;

import com.example.desafio1.dtos.ProductDTO;
import com.example.desafio1.models.Product;

public class ProductMapper {
    public static Product toModel(ProductDTO prodDTO){
        Product prod = new Product();
        prod.setProductId(prodDTO.getProductId());
        prod.setProductName(prodDTO.getProductName());
        prod.setBrand(prodDTO.getBrand());
        prod.setColor(prodDTO.getColor());
        prod.setNotes(prodDTO.getNotes());
        prod.setType(prodDTO.getType());

        return prod;
    }

    public static ProductDTO toDTO(Product product){
        ProductDTO prodDTO = new ProductDTO();
        prodDTO.setProductId(product.getProductId());
        prodDTO.setProductName(product.getProductName());
        prodDTO.setBrand(product.getBrand());
        prodDTO.setColor(product.getColor());
        prodDTO.setNotes(product.getNotes());
        prodDTO.setType(product.getType());

        return prodDTO;
    }
}
