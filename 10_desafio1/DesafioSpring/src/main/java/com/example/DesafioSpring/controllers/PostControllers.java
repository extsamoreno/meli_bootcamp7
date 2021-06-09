package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.PostDTO;
import com.example.DesafioSpring.exceptions.*;
import com.example.DesafioSpring.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/products" )
public class PostControllers {
    @Autowired
    IPostService iPostService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost (@RequestBody PostDTO postDTO) throws DateTimeParseException, ProductTakenException, PostTakenException, UserNotFoundException, PostNotFoundException {

        iPostService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostDTO>> getFollowedPosts (@PathVariable int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(iPostService.getFollowedPost(userId) ,HttpStatus.OK);
    }
}
