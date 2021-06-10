package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.dtos.ProductBaseResponseDTO;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;

public class ProductListMapper {

    public static ProductResponseDTO toDTO(User user, ArrayList<Product> products){

        return new ProductResponseDTO(user.getId(), user.getUserName(), arrayToProductResponseDTO(products));
    }

    public static ArrayList<ProductBaseResponseDTO> arrayToProductResponseDTO(ArrayList<Product> products){

        ArrayList<ProductBaseResponseDTO> productsDTO = new ArrayList<>();
        for (Product product: products) {
            productsDTO.add(
                new ProductBaseResponseDTO(
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
