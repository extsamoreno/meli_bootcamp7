package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.PostService;
import com.socialmeli.socialmeli.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        postService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@RequestBody PostPromoDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        postService.newPromoPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ProductUserPromoDTO> getPromoProductsCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(
                postService.getProductPromoCount(userId),HttpStatus.OK
        );
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<ListPostPromoDTO> getPromoProducts(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(
                postService.getProductsPromo(userId),HttpStatus.OK
        );
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListPostDTO> getFollowedPostList(@PathVariable Integer userId,@RequestParam Optional<String> order) throws UserNotFoundException {
        return new ResponseEntity<>(
                postService.getFollowedPostList(userId,order),HttpStatus.OK
        );
    }



}