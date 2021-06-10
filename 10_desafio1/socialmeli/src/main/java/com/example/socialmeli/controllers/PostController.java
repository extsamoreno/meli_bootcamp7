package com.example.socialmeli.controllers;

import com.example.socialmeli.dtos.PostListDTO;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.postExceptions.MissingDataException;
import com.example.socialmeli.exceptions.postExceptions.PostAlreadyExistException;
import com.example.socialmeli.models.Post;
import com.example.socialmeli.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/products/newpost")
    public ResponseEntity<HttpStatus> newPost(@RequestBody Post post) throws UserNotFoundException, PostAlreadyExistException, MissingDataException {
        return new ResponseEntity<>(postService.newPost(post),HttpStatus.CREATED);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> postList(@PathVariable Integer userId,
                                                @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<PostListDTO>(postService.getPostByUserId(userId, order),HttpStatus.OK);
    }

}
