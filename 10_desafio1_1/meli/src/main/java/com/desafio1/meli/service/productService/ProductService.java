package com.desafio1.meli.service.productService;

import com.desafio1.meli.repository.productRepository.IProductrepository;
import com.desafio1.meli.repository.userRepository.IUserrepository;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService implements IProductservice {

    @Autowired
    IProductrepository iProductrepository;

    @Override
    public boolean newProduct(RequestNewProduct requestNewProduct) {
        return iProductrepository.newProduct(requestNewProduct);
    }

    @Override
    public ResponseFollowersListDTO listProductFollowerUser(Integer user_id) {
        return iProductrepository.getProductListFollow(user_id);
    }
}