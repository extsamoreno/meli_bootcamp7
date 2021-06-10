package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.post.ProductDTO;
import com.meli.socialmeli.model.Product;

public class ProductMapper {
    public static Product toProduct(ProductDTO productDTO) {
        return new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }
}
