package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductBaseResponseDTO;
import com.desafio_1.demo.models.Product;

public class ProductMapper {

    public static ProductBaseResponseDTO toDTO(Product product){

        return new ProductBaseResponseDTO(
                product.getUserId(),
                product.getIdPost(),
                product.getDate(),
                ProductDetailMapper.toDTO(product.getDetail()),
                product.getCategory(),
                product.getPrice(),
                product.isHasPromo(),
                product.getDiscount()
        );
    }
    public static Product toModel(ProductRequestDTO product){

        return new Product(
                product.getUserId(),
                product.getIdPost(),
                product.getDate(),
                ProductDetailMapper.toModel(product.getDetail()),
                product.getCategory(),
                product.getPrice(),
                product.isHasPromo(),
                product.getDiscount()
                );
    }
}
