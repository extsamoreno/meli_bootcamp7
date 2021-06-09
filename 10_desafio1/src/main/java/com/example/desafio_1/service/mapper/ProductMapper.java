package com.example.desafio_1.service.mapper;

import com.example.desafio_1.models.Product;
import com.example.desafio_1.service.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements IGenericMapper<Product, ProductDTO, Object> {
    @Override
    public ProductDTO toDto(Product model) {
        return new ProductDTO(model.getId(), model.getName(), model.getType(), model.getBrand(), model.getColor(), model.getNotes());
    }

    @Override
    public Product toModel(ProductDTO dto) {
        return new Product(dto.getProduct_id(), dto.getProductName(), dto.getType(), dto.getBrand(), dto.getColor(), dto.getNotes());
    }

    @Override
    public Object toDtoResponse(Product model) {
        return null;
    }
}
