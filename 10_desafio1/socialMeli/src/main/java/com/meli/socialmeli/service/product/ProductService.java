package com.meli.socialmeli.service.product;

import com.meli.socialmeli.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;
}
