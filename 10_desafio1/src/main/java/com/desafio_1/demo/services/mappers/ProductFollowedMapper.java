package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductFollowedDTO;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductFollowedMapper {

    public static ProductFollowedDTO toDTO(int userId, ArrayList<Product> products){

        return new ProductFollowedDTO(userId, arrayToProductResponseDTO(products));
    }

    public static ArrayList<ProductResponseDTO> arrayToProductResponseDTO(ArrayList<Product> products){

        ArrayList<ProductResponseDTO> productsDTO = new ArrayList<>();
        for (Product product: products) {
            productsDTO.add(
                new ProductResponseDTO(
                    product.getUserId(),
                    product.getIdPost(),
                    product.getDate(),
                    ProductDetailMapper.toDTO(product.getDetail()),
                    product.getCategory(),
                    product.getPrice(),
                    product.isHasPromo(),
                    product.getDiscount()
            ));
        }
        return productsDTO;

    }
}
