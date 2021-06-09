package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.FollowedPostsDTO;
import com.meli.socialmeli.dto.NewPostDTO;
import com.meli.socialmeli.dto.NewPromoPostDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService iPostService;

    //Requirement US 0005
    @PostMapping("/newpost")
    public ResponseEntity<?> newPost(@RequestBody NewPostDTO newPost) throws UserIdNotFoundException {
        iPostService.addPost(newPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Requirement US 0006/009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDTO> getFollowedPosts(@PathVariable Integer userId, @RequestParam(required = false) String order) throws UserIdNotFoundException {
        return new ResponseEntity<>(iPostService.getFollowedPosts(userId,order), HttpStatus.OK);
    }

    //Requirement US 0010
    @PostMapping("/newpromopost")
    public ResponseEntity<?> newPromoPost(@RequestBody NewPromoPostDTO newPromoPost) throws UserIdNotFoundException {
        iPostService.addPromoPost(newPromoPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Requirement US 0011
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<?> getPromoPostCount(@PathVariable Integer userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iPostService.getPromoPostCount(userId), HttpStatus.OK);
    }
}