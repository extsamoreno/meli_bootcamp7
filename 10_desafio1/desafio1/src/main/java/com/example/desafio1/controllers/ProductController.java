package com.example.desafio1.controllers;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoCountDTO;
import com.example.desafio1.dtos.PostPromoDTO;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public String generateNewPost(@RequestBody PostDTO post){
        iProductService.processNewPost(post);
        return "Your product has been published successfully!";
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostDTO>> getFollowedPosts(@PathVariable int userId, @RequestParam(required = false) String order) throws OrderNotValidException {
        return new ResponseEntity<>(iProductService.getFollowedPosts(userId,order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    @ResponseStatus(HttpStatus.OK)
    public String generateNewPromoPost(@RequestBody PostPromoDTO post){
        iProductService.processNewPost(post);
        return "Product has been published successfully!";
    }

    @GetMapping("/{userId}/countPromo/")
    public ResponseEntity<PostPromoCountDTO> getPromoPostsCount(@PathVariable int userId){
        return new ResponseEntity<>(iProductService.getPromoPostsCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/list/")
    public ResponseEntity<List<PostDTO>> getPromoPosts(@PathVariable int userId){
        return new ResponseEntity<>(iProductService.getPromoPosts(userId),HttpStatus.OK);
    }

}