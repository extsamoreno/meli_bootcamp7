package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.post.ProductDTO;
import com.meli.socialmeli.model.Product;

public class ProductMapper {
    public static Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setType(productDTO.getType());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setNotes(productDTO.getNotes());
        return product;
    }

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setType(product.getType());
        productDTO.setBrand(product.getBrand());
        productDTO.setColor(product.getColor());
        productDTO.setNotes(product.getNotes());
        return productDTO;
    }
}
