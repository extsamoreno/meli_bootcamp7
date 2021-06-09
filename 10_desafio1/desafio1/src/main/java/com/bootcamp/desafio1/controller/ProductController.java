package com.bootcamp.desafio1.controller;

import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;

import com.bootcamp.desafio1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productServiceImpl;


    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPost(@RequestBody NewPostDTO newPostDTO) throws PostAlreadyExistsException, ProductAlreadyExistsException {
        productServiceImpl.insertNewPost();
    }

}
