package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.PostErrorException;
import com.meli.desafio.models.Post;
import com.meli.desafio.services.IPostService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService postService;

    @GetMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody Post post) throws PostErrorException {
        return new ResponseEntity<>(URLBuilder.buildURL("products", postService.addNewPost(post), ""), HttpStatus.OK);
    }
}
