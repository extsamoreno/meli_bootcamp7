package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;
import com.bootcamp.desafio1.repository.post.IPostRepository;
import com.bootcamp.desafio1.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IUserService userServiceImpl;

    @Autowired
    IPostRepository postRepositoryImpl;

    @Autowired
    IProductRepository productRepositoryImpl;


    @Override
    public void insertNewPost() throws PostAlreadyExistsException, ProductAlreadyExistsException {
        
    }
}
