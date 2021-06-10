package com.example.SocialMeli.Services.Mapper;



import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Services.DTOs.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){

        return new ProductDTO(product.getId(),product.getName(), product.getType(), product.getColor(), product.getNotes());
    }

    public static Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getType(), productDTO.getColor(), productDTO.getNotes());
    }
}
