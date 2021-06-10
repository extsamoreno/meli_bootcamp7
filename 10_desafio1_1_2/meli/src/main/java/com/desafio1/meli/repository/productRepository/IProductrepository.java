package com.desafio1.meli.repository.productRepository;

import com.desafio1.meli.exceptions.FailCreatePublicationException;
import com.desafio1.meli.exceptions.NotExistUser;
import com.desafio1.meli.service.DTO.RequestFollowedProductList;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;

import java.time.LocalDate;

public interface IProductrepository {
    boolean newProduct(RequestNewProduct requestNewProduct) throws FailCreatePublicationException;
    RequestFollowedProductList getProductListFollow (Integer userId, LocalDate dateFrome, LocalDate dateBefore) throws NotExistUser;
    RequestFollowedProductList getProductListPromo (Integer userId) throws NotExistUser;
}
