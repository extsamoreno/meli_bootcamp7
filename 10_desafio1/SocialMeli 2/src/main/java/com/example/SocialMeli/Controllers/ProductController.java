package com.example.SocialMeli.Controllers;

import com.example.SocialMeli.Exceptions.*;

import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;

@RestController
public class ProductController {

    @Autowired
    iProductService iProductService;

    @PostMapping("/products/newpost")
    public ResponseEntity<Void> makePost (@RequestBody NonPromoPostDTO postDTO) throws DateTimeParseException, ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException {

        iProductService.makePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/products/newpromopost")
    public ResponseEntity<Void> makePromoPost (@RequestBody PromoPostDTO postDTO) throws DateTimeParseException, ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException {
        iProductService.makePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostsDTO> getFollowedPosts (@PathVariable int userId, @RequestParam(defaultValue="date_desc") String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(iProductService.getFollowedPost(userId, order) ,HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/countPromo")
    public ResponseEntity<PostCountDTO> getUserPromPostCount (@PathVariable int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {
        return new ResponseEntity<>(iProductService.getPromPostsCant(userId) ,HttpStatus.OK);
    }
    @GetMapping("/products/{userId}/list")
    public ResponseEntity<PostsDTO> getUserPromPosts (@PathVariable int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {
        return new ResponseEntity<>(iProductService.getPromPostsByUser(userId) ,HttpStatus.OK);
    }
}
