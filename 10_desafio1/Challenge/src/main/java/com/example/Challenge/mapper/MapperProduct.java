package com.example.Challenge.mapper;

import com.example.Challenge.dto.ProductDTO;
import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.model.Product;


public class MapperProduct {
    public static ProductDTO toProductDTO(Product product){
        ProductDTO productResult = new ProductDTO(
                                    product.getIdPost(),
                                    product.getDate(),product.getDetail(),
                                    product.getCategory(),product.getPrice());
        return productResult;
    }
}
