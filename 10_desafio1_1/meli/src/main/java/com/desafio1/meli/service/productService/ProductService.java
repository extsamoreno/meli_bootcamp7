package com.desafio1.meli.service.productService;

import com.desafio1.meli.repository.productRepository.IProductrepository;
import com.desafio1.meli.repository.userRepository.IUserrepository;
import com.desafio1.meli.service.DTO.RequestFollowedProductList;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ProductService implements IProductservice {

    @Autowired
    IProductrepository iProductrepository;

    @Override
    public boolean newProduct(RequestNewProduct requestNewProduct) {
        return iProductrepository.newProduct(requestNewProduct);
    }

    @Override
    public RequestFollowedProductList listProductFollowerUser(Integer user_id) {
        LocalDate dateFrom = LocalDate.now().minusDays(14);
        LocalDate dateBefor = LocalDate.now();
        return iProductrepository.getProductListFollow(user_id, dateFrom, dateBefor);
    }
}