package com.example.desafio1.controller;

import com.example.desafio1.exception.PostIdAlreadyInUseException;
import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.model.Product;
import com.example.desafio1.model.ProductPost;
import com.example.desafio1.service.IPostService;
import com.example.desafio1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IProductService iProductService;

    @Autowired
    IPostService iPostService;

    @PostMapping("/newpost")
    public ResponseEntity<String> createNewPost(@RequestBody ProductPost productPost)
            throws ProductNotFoundException, ProductInconsistencyException,
            PostIdAlreadyInUseException
    {
        return new ResponseEntity<>(iPostService.createPost(productPost), HttpStatus.OK);
    }

    @GetMapping("/catalog")
    public ResponseEntity<HashMap<Integer, Product>> getCatalog()
    {
        return new ResponseEntity<>(iProductService.getCatalog(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<HashMap<Integer, ProductPost>> getPosts()
    {
        return new ResponseEntity<>(iPostService.getPosts(), HttpStatus.OK);
    }
}
