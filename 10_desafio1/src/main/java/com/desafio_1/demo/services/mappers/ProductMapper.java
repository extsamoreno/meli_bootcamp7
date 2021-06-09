package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.ProductDetail;

public class ProductMapper {

    public static ProductResponseDTO toDTO(Product product){

        return new ProductResponseDTO(
                product.getUserId(),
                product.getIdPost(),
                product.getDate(),
                ProductDetailMapper.toDTO(product.getDetail()),
                product.getCategory(),
                product.getPrice()
        );
    }
    public static Product toModel(ProductRequestDTO product){

        return new Product(
                product.getUserId(),
                product.getIdPost(),
                product.getDate(),
                ProductDetailMapper.toModel(product.getDetail()),
                product.getCategory(),
                product.getPrice()
                );
    }
}
