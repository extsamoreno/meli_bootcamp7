package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.SocialExceptionMissingParameter;
import com.meli.socialmeli.exception.SocialExceptionUserNotExists;
import com.meli.socialmeli.service.IPostService;
import com.meli.socialmeli.service.dto.PostDTO;
import com.meli.socialmeli.service.dto.PostFollowingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> addPost(@RequestBody PostDTO postDTO) {
        postService.addPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/following/{userId}/list")
    public ResponseEntity<PostFollowingDTO> getListPostUsersFollowingByUserId(@PathVariable Integer userId, @RequestParam(required = false) String order) throws SocialExceptionMissingParameter, SocialExceptionUserNotExists {
        return new ResponseEntity<>(postService.getListPostUsersFollowingByUserId(userId, order), HttpStatus.OK);
    }
}