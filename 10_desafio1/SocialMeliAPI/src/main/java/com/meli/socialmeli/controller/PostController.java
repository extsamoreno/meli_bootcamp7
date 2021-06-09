package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.PromotionPost;
import com.meli.socialmeli.service.IPostService;
import com.meli.socialmeli.service.dto.PostDTOFollowedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    IPostService iPostService;

    @PostMapping("/products/newpost")
    public ResponseEntity<HttpStatus> addNewPost(@RequestBody Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        HttpStatus status= iPostService.addNewPost(post);
        return new ResponseEntity<>(status, status);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostDTOFollowedList> getFollowedUserPosts(@PathVariable int userId, @RequestParam(required = false) String order) throws IncorrectOrderTypeException {
        return new ResponseEntity<>(iPostService.getFollowedUserPosts(userId, order),HttpStatus.OK);
    }

    @PostMapping("/products/newpromopost")
    public ResponseEntity<HttpStatus> addNewPromotionPost(@RequestBody PromotionPost promoPost) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        HttpStatus status= iPostService.addNewPromotionPost(promoPost);
        return new ResponseEntity<>(status, status);
    }
}
