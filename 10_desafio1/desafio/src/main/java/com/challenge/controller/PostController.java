package com.challenge.controller;

import com.challenge.dto.NewPostRequest;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity addNewPost(@RequestBody NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException {
        postService.addNewPost(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity getRecentPosts(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(postService.getRecentPosts(userId));
    }



}
