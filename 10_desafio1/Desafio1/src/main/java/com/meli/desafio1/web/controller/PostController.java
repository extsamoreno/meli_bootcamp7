package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService postService;
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getPosts(){
        return new ResponseEntity<>(postService.getPost(), HttpStatus.OK);
    }
}
