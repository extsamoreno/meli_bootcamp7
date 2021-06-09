package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.model.Product;
import com.meli.socialmeli.service.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO modelToDTO(Product model) {
        return new ProductDTO(model.getProductId(), model.getProductName(), model.getType(), model.getBrand(), model.getColor(), model.getNotes());
    }

    public static Product DTOToModel(ProductDTO dto) {
        return new Product(dto.getProductId(), dto.getProductName(), dto.getType(), dto.getBrand(), dto.getColor(), dto.getNotes());
    }
}
