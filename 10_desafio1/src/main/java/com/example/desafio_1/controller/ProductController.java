package com.example.desafio_1.controller;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.service.IPostService;
import com.example.desafio_1.service.IProductService;
import com.example.desafio_1.service.dto.FollowedPostDTO;
import com.example.desafio_1.service.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostDTO> getFollowedUsersPosts(@PathVariable int userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws UserExceptionWrongType, UserExceptionNotFound, WrongOrderFieldException {
        return new ResponseEntity<FollowedPostDTO>(postService.getFollowedUsersPostsByUserId(userId, order), HttpStatus.OK);
    }

}
