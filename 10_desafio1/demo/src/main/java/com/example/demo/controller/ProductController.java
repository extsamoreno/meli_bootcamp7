package com.example.demo.controller;

import com.example.demo.model.DTO.PostDTO;
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
    public ResponseEntity<?> newPost(@RequestBody PostDTO postDTO){
            return new ResponseEntity<>(productService.newPost(postDTO.getUserId(), postDTO.getPostId(), postDTO.getDate(), postDTO.getDetail().getProductId(),
                    postDTO.getDetail().getProductName(), postDTO.getDetail().getType(), postDTO.getDetail().getBrand(), postDTO.getDetail().getColor(), postDTO.getDetail().getNotes(),
                    postDTO.getCategory(), postDTO.getPrice()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> followedPostsList(@PathVariable int userId,
                                               @RequestParam(name = "order", required = false, defaultValue = "date_asc") String order){
        return new ResponseEntity<>(productService.getOrderedPosts(userId, order), HttpStatus.OK);
    }




}
