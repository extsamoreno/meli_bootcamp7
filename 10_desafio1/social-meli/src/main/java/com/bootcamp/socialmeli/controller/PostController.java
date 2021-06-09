package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.ListFollowedPostDTO;
import com.bootcamp.socialmeli.DTO.PostRequestDTO;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@Valid @RequestBody PostRequestDTO post)
            throws UserIdNotFoundException, PostAlreadyRegisteredException {

        productService.newPost(post);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/followed/{userId}/list")
    public ResponseEntity<ListFollowedPostDTO> getFollowedPosts(@PathVariable Integer userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(productService.getFollowedPost(userId), HttpStatus.OK);
    }
}
