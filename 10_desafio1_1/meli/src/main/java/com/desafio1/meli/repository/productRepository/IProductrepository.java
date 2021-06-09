package com.desafio1.meli.repository.productRepository;

import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;

public interface IProductrepository {
    boolean newProduct(RequestNewProduct requestNewProduct);
    ResponseFollowersListDTO getProductListFollow (Integer userId);
}
