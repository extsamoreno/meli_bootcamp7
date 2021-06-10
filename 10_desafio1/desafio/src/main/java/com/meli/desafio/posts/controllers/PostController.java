package com.meli.desafio.posts.controllers;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.exceptions.PostNotPromoException;
import com.meli.desafio.posts.models.dto.*;
import com.meli.desafio.posts.services.IPostService;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.utils.URLBuilder;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "get a post by id")
    @ApiResponse(code = 200, message = "Ok", response = PostPromoDTO.class)
    public ResponseEntity<PostPromoDTO> getPostById(@PathVariable Integer postId) throws PostNotExistException {
        return new ResponseEntity<>(postService.getById(postId), HttpStatus.OK);
    }

    @PostMapping("/newpost")
    @Operation(summary = "add a new post")
    @ApiResponse(code = 200, message = "Ok", response = String.class, examples = @Example(
            value = {
                    @ExampleProperty(value = "localhost:8080/products/1", mediaType = "string")
            }
    ))
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) throws PostErrorException {
        return new ResponseEntity<>(
                URLBuilder.buildURL("products", postService.addNewPost(postDTO), ""),
                HttpStatus.OK
        );
    }

    //all post of user
    @GetMapping("/{userId}/list")
    @Operation(summary = "get all posts of a user")
    @ApiResponse(code = 200, message = "Ok", response = ResponseListPostsDto.class)
    public ResponseEntity<ResponseListPostsDto> getPostsList(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPostList(userId), HttpStatus.OK);
    }

    //all post of followed user
    @GetMapping("/followed/{userId}/list")
    @Operation(summary = "get all posts from users you follow")
    @ApiResponse(code = 200, message = "Ok", response = ResponseListPostsDto.class)
    public ResponseEntity<List<ResponseListPostsDto>> getPostListForUsersFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "date_asc") String order
    ) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPostListForUsersFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    @Operation(summary = "add a new post with promo")
    @ApiResponse(code = 200, message = "Ok", response = String.class, examples = @Example(
            value = {
                    @ExampleProperty(value = "localhost:8080/products/1", mediaType = "string")
            }
    ))
    public ResponseEntity<String> addNewPromoPost(@RequestBody PostPromoDTO postPromoDTO) throws PostErrorException, PostNotPromoException {
        return new ResponseEntity<>(URLBuilder.buildURL(
                "products", postService.addNewPromoPot(postPromoDTO), ""),
                HttpStatus.OK
        );
    }

    @GetMapping("/{userId}/countpromo")
    @Operation(summary = "get count of posts that are promo by a user")
    @ApiResponse(code = 200, message = "Ok", response = PromoCountDTO.class)
    public ResponseEntity<PromoCountDTO> getCountPromos(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getCountPromos(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/listpromo")
    @Operation(summary = "get list of posts that are promoted by a user")
    @ApiResponse(code = 200, message = "Ok", response = PostPromoListDTO.class)
    public ResponseEntity<PostPromoListDTO> getListPromos(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "date_asc") String order
    ) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getListPromos(userId, order), HttpStatus.OK);
    }
}
