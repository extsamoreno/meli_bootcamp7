package com.meli.desafio.posts.controllers;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.exceptions.PostNotPromoException;
import com.meli.desafio.posts.models.dto.*;
import com.meli.desafio.posts.services.IPostService;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostPromoDTO> getPostById(@PathVariable Integer postId) throws PostNotExistException {
        return new ResponseEntity<>(postService.getById(postId), HttpStatus.OK);
    }

    @PostMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) throws PostErrorException {
        return new ResponseEntity<>(
                URLBuilder.buildURL("products", postService.addNewPost(postDTO), ""),
                HttpStatus.OK
        );
    }

    //all post of user
    @GetMapping("/{userId}/list")
    public ResponseEntity<ResponseListPostsDto> getPostsList(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPostList(userId), HttpStatus.OK);
    }

    //all post of followed user
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<ResponseListPostsDto>> getPostListForUsersFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "date_asc") String order
    ) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPostListForUsersFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody PostPromoDTO postPromoDTO) throws PostErrorException, PostNotPromoException {
        return new ResponseEntity<>(URLBuilder.buildURL(
                "products", postService.addNewPromoPot(postPromoDTO), ""),
                HttpStatus.OK
        );
    }

    @GetMapping("/{userId}/countpromo")
    public ResponseEntity<PromoCountDTO> getCountPromos(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getCountPromos(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/listpromo")
    public ResponseEntity<PostPromoListDTO> getListPromos(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getListPromos(userId), HttpStatus.OK);
    }
}
