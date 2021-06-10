package com.example.Challenge.mapper;

import com.example.Challenge.dto.ProductDTO;
import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.model.Product;


public class MapperProduct {

    // Convert Product to ProductDTO
    public static ProductDTO toProductDTO(Product product){
        if(product.isHasPromo()){
            ProductDTO productResult = new ProductDTO(
                    product.getIdPost(),
                    product.getDate(),product.getDetail(),
                    product.getCategory(),product.getPrice(),true,product.getDiscount());
            return productResult;
        }
        else {ProductDTO productResult = new ProductDTO(
                product.getIdPost(),
                product.getDate(),product.getDetail(),
                product.getCategory(),product.getPrice());
            return productResult;
        }

    }
}
