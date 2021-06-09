package com.example.demo.controller;

import com.example.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<?> newPost(@RequestBody int userId, int idPost, Date date, int productId, String productName, String type, String brand, String color, String notes, int category, double price){
        return new ResponseEntity<>(productService.newPost(userId, idPost, date, productId, productName, type, brand, color, notes, category, price), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(@PathVariable int userId){
        return new ResponseEntity<>(productService.getPostsFromFollowed(userId), HttpStatus.OK);
    }
}
