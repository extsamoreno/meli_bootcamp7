package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dto.UserPostListODT;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;
import com.meli.socialmeli.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prodcuts")
public class ProductController {

    @Autowired
    IPostService iPostService;

    @PostMapping("/newpost")
    public ResponseEntity<UserMeli> SetNewPost(@RequestBody Post post){
        Post post1 = new Post();

        return new ResponseEntity<>(iPostService.newPost(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostListODT> getListPost(@PathVariable int userId){

        return new ResponseEntity<>(iPostService.getListPosts(userId), HttpStatus.OK);
    }
}
