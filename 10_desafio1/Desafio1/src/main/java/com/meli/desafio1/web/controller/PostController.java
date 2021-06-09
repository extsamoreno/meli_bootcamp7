package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService ipostService;
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostDTO>> getPosts(@PathVariable("userId") int userId, @RequestParam(value = "order", required = false, defaultValue = "date_desc") String order){
        return new ResponseEntity<>(ipostService.followedPostByUserId(userId,order), HttpStatus.OK);
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO){
        ipostService.createPost(postDTO);
        return new ResponseEntity<>(ResponseEntity.noContent().build(), HttpStatus.OK);
    }
}
