package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;

public interface IProductService {

    void insertNewPost() throws PostAlreadyExistsException, ProductAlreadyExistsException;

}
