package com.example.socialmeli.mapper;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toProductDTO(Product obj) {
        ProductDTO response = new ProductDTO();
        response.setProduct_id(obj.getProduct_id());
        response.setProductName(obj.getProductName());
        response.setType(obj.getType());
        response.setBrand(obj.getBrand());
        response.setColor(obj.getColor());
        response.setNotes(obj.getNotes());
        return response;
    }

    public Product toProduct(ProductDTO obj) {
        Product response = new Product();
        response.setProduct_id(obj.getProduct_id());
        response.setProductName(obj.getProductName());
        response.setType(obj.getType());
        response.setBrand(obj.getBrand());
        response.setColor(obj.getColor());
        response.setNotes(obj.getNotes());
        return response;
    }
}
