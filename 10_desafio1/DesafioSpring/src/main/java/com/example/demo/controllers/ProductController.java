package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.CategoryDoesntExistException;
import com.example.demo.exceptions.InvalidDateFormatException;
import com.example.demo.exceptions.ProductDontFoundException;
import com.example.demo.exceptions.UserDontFoundException;
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

    @PostMapping("/newpost")      //US 0005
    public ResponseEntity<NewPostResponseDTO> newPost(@RequestBody NewPostRequestDTO newPostRequestDTO) throws ParseException, UserDontFoundException, ProductDontFoundException, CategoryDoesntExistException, InvalidDateFormatException {
        return new ResponseEntity<>(productService.newPost(newPostRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")     //US 0006 y US 0009
    public ResponseEntity<FollowedPostListResponseDTO> followedPostList(@PathVariable int userId,@RequestParam(defaultValue = "date_asc") String order) throws InvalidDateFormatException {
        return new ResponseEntity<>(productService.getFollowedPostList(userId,order),HttpStatus.OK);
    }

    @PostMapping("/newpromopost")      //US 0010
    public ResponseEntity<NewPostWithPromResponseDTO> newPostWithProm(@RequestBody NewPostWithPromRequestDTO newPostWithPromRequestDTO) throws ParseException, UserDontFoundException, ProductDontFoundException, CategoryDoesntExistException, InvalidDateFormatException {
        return new ResponseEntity<>(productService.newPostWithProm(newPostWithPromRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/countPromo/")    // 0011
    public ResponseEntity<PostWithPromCountDTO> gePostsWithProm(@PathVariable int userId) throws UserDontFoundException {
        return new ResponseEntity<>(productService.getPostsWithPromCount(userId), HttpStatus.OK);
    }
    @GetMapping("/{userId}/list/")      // 0012
    public ResponseEntity<PostWithPromListResponseDTO> gePostWithPromList(@PathVariable int userId) throws UserDontFoundException, InvalidDateFormatException {
        return new ResponseEntity<>(productService.getPostsWithPromList(userId), HttpStatus.OK);
    }
}
