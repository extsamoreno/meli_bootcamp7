package com.example.desafio_1.controller;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.service.IPostService;
import com.example.desafio_1.service.IProductService;
import com.example.desafio_1.service.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @Autowired
    IPostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostDTO post) throws UserExceptionWrongType, PostExceptionNotValid, ProductExceptionNotValid, ProductExceptionNotFound, UserExceptionNotFound, NumberNotGreaterThanZero, EmptyStringException, PostExceptionNotExists, PostExceptionAlreadyExists {
        postService.createPostByDTO(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
