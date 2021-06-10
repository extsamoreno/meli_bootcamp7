package com.socialmedia.socialmedia.mappers;

import com.socialmedia.socialmedia.repositories.entities.Post;
import com.socialmedia.socialmedia.repositories.entities.Product;
import com.socialmedia.socialmedia.services.dtos.PostDTO;
import com.socialmedia.socialmedia.services.dtos.ProductDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedPostsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductMapper {
    public static Product productDtoToProduct(ProductDTO productDTO) {
        var product = new Product();

        product.setId(productDTO.getProductId());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setName(productDTO.getProductName());
        product.setNotes(productDTO.getNotes());
        product.setType(productDTO.getType());

        return product;
    }

    public static ProductDTO productToProductDTO(Product product) {
        var productDTO = new ProductDTO();

        productDTO.setProductId( product.getId());
        productDTO.setProductName(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setColor(product.getColor());
        productDTO.setNotes(product.getNotes());
        productDTO.setType(product.getType());

        return productDTO;
    }
}
