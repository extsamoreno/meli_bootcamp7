package com.example.desafio1.controller;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.service.dto.post.ResponseListFollowedSellers;
import com.example.desafio1.service.iPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    iPostService iPostService;

    // Create a new post
    @PostMapping("/newpost")
    public ResponseEntity<Void> createPost(@RequestBody Post post) throws PostAlreadyExistException, UserNotFoundException {
        iPostService.createPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Returns a list with seller posts that user (userId) followed
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseListFollowedSellers> listPostsFollowed(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_desc") String order) throws UserNotFoundException {
        return new ResponseEntity<>(iPostService.listPostsFollowed(userId, order), HttpStatus.OK);
    }



}

