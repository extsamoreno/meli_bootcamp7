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

    @PostMapping("/newpost")
    public ResponseEntity<Void> createPost(@RequestBody Post post) throws PostAlreadyExistException, UserNotFoundException {
        iPostService.createPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseListFollowedSellers> listPostsFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iPostService.listPostsFollowed(userId), HttpStatus.OK);
    }
}

