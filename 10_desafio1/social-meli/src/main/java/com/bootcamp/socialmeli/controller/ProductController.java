package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.PostRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {



    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostRequestDTO post) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
