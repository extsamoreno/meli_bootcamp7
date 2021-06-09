package com.example.demo.controllers;

import com.example.demo.dtos.FollowedPostListResponseDTO;
import com.example.demo.dtos.NewPostRequestDTO;
import com.example.demo.dtos.NewPostResponseDTO;
import com.example.demo.exceptions.CategoryDoesntExistException;
import com.example.demo.exceptions.ProductDoesntExistException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/newpost")        //US 0005
    public ResponseEntity<NewPostResponseDTO> newPost(@RequestBody NewPostRequestDTO newPostRequestDTO) throws ParseException, UserDoesntExistException, ProductDoesntExistException, CategoryDoesntExistException {
        return new ResponseEntity<>(productService.newPost(newPostRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")     //US 0006 y US 0009
    public ResponseEntity<FollowedPostListResponseDTO> followedPostList(@PathVariable int userId,@RequestParam String order){
        return new ResponseEntity<>(productService.getFollowedPostList(userId,order),HttpStatus.OK);
    }
}
