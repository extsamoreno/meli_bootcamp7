package com.example.desafiospring.socialmeli.controller;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.service.DTO.PostListDTO;
import com.example.desafiospring.socialmeli.service.IPostService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products") //mapping de 0005, products
public class PostController {

    @Autowired
    IPostService IPostService;

    @PostMapping("/newpost") //post de newpost, 0005
    public ResponseEntity<Void> newPost(@RequestBody Post post) throws UserNotFoundException {
        IPostService.newPost(post); //chusmear porque queda en rojo
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list") //get 0006
    public ResponseEntity<PostListDTO> getFollowedPostList(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(
                IPostService.getFollowedPostList(userId), HttpStatus.OK
        );
    }
}