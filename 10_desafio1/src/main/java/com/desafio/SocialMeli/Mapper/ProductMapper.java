package com.desafio.SocialMeli.Mapper;

import com.desafio.SocialMeli.Classes.Product;
import com.desafio.SocialMeli.DTO.Product.ProductDTO;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getProduct_id(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    public static Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());
    }
}
