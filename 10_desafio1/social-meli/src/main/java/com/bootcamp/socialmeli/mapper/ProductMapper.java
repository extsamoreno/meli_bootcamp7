package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.DTO.ProductDTO;
import com.bootcamp.socialmeli.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProdcut(ProductDTO productDTO) {
        return new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes()
        );
    }
}
