package com.desafio1.meli.repository.productRepository;

import com.desafio1.meli.service.DTO.RequestFollowedProductList;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;

import java.time.LocalDate;

public interface IProductrepository {
    boolean newProduct(RequestNewProduct requestNewProduct);
    RequestFollowedProductList getProductListFollow (Integer userId, LocalDate dateFrome, LocalDate dateBefore);
}
