package com.meli.socialmeli.controllers;

import com.meli.socialmeli.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prodcuts")
public class ProductController {

    @PostMapping("/newpost")
    public ResponseEntity<Post> SetNewPost(@RequestBody Post post){
        Post post1 = new Post();

        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
