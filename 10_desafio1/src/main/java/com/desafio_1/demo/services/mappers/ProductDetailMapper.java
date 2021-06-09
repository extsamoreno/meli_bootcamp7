package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductDetailDTO;
import com.desafio_1.demo.models.ProductDetail;

public class ProductDetailMapper {
    public static ProductDetail toModel(ProductDetailDTO product){
        return new ProductDetail(product.getProduct_id(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    public static ProductDetailDTO toDTO(ProductDetail product){
        return new ProductDetailDTO(product.getProduct_id(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }
}
