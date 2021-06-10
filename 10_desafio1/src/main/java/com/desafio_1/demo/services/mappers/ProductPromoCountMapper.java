package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.ProductPromoCountDTO;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.User;

public class ProductPromoCountMapper {

    public static ProductPromoCountDTO toDTO(User user, int size){
        return new ProductPromoCountDTO(user.getId(), user.getUserName(), size);
    }
}
