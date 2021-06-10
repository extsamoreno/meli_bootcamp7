package com.desafio1.meli.service.productService;

import com.desafio1.meli.service.DTO.RequestFollowedProductList;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;
import com.desafio1.meli.service.orderType.PublicationOrderType;

public interface IProductservice {
    boolean newProduct(RequestNewProduct requestNewProduct);
    RequestFollowedProductList listProductFollowerUser(Integer user_id, PublicationOrderType order);
}
