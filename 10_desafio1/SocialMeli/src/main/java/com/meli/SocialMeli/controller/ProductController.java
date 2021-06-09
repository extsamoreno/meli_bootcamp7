package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.PostDto;
import com.meli.SocialMeli.dto.ProductDto;
import com.meli.SocialMeli.dto.UserFollowedpostDto;
import com.meli.SocialMeli.exception.InvalidPostException;
import com.meli.SocialMeli.exception.InvalidProductException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping(path = "/newpost")
    public ResponseEntity<String> newPost(@RequestBody PostDto postDto) throws ParseException, InvalidProductException, InvalidPostException {
        iProductService.newPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/followed/{userId}/list")
    public ResponseEntity<UserFollowedpostDto> getFollowedPosts(@PathVariable("userId") int userId) throws InvalidUserIdException {
        return new ResponseEntity<>(iProductService.getFollowedPost(userId),HttpStatus.OK);
    }
}
