package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.PostDto;
import com.meli.SocialMeli.dto.UserFollowedpostDto;
import com.meli.SocialMeli.dto.UserPostCountDto;
import com.meli.SocialMeli.dto.UserPostDto;
import com.meli.SocialMeli.exception.InvalidPostException;
import com.meli.SocialMeli.exception.InvalidProductException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping(path = "/newpost")
    public ResponseEntity<String> newPost(@RequestBody PostDto postDto) throws ParseException, InvalidProductException, InvalidPostException {
        iProductService.newPost(postDto);
        return new ResponseEntity<String>("New post created successfully",HttpStatus.OK);
    }

    @PostMapping(path = "/newpromopost")
    public ResponseEntity<String> newPromoPost(@RequestBody PostDto postDto) throws ParseException, InvalidProductException, InvalidPostException {
        iProductService.newPost(postDto);
        return new ResponseEntity<String>("New promotion posted created successfully",HttpStatus.OK);
    }

    @GetMapping(path = "/followed/{userId}/list")
    public ResponseEntity<UserFollowedpostDto> getFollowedPosts(@PathVariable("userId") int userId, @RequestParam("order") Optional<String> order) throws InvalidUserIdException {
        return new ResponseEntity<>(iProductService.getFollowedPost(userId,order),HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}/countpromo")
    public ResponseEntity<UserPostCountDto> getPromPostList(@PathVariable("userId") int userId){
        return new ResponseEntity<UserPostCountDto>(iProductService.getUserPromoCount(userId),HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}/list")
    public ResponseEntity<UserPostDto> getPromPost(@PathVariable("userId") int userId){
        return new ResponseEntity<UserPostDto>(iProductService.getUserPromo(userId),HttpStatus.OK);
    }
}
