package com.example.demo.controller;

import com.example.demo.DTO.*;
import com.example.demo.exception.GenericException;
import com.example.demo.exception.OrderErrorException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductServices productServices;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostDTO post) throws UserNotFoundException {
        productServices.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getPostList(@PathVariable Integer userId,@RequestParam(required = false, value = "order",defaultValue = "date_desc") String order) throws OrderErrorException {
        return new ResponseEntity<>(productServices.getPostList(userId,order),HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@RequestBody PromoPostDTO promoPost) throws GenericException {
        productServices.newPromoPost(promoPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoPostCountDTO> countPromo (@PathVariable Integer userId) throws GenericException {
        return new ResponseEntity<>(productServices.countPromo(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoPostListDTO> getPromoPostList(@PathVariable Integer userId,@RequestParam(required = false, value = "order",defaultValue = "name_asc") String order) throws GenericException {
        return new ResponseEntity<>(productServices.getPromoPostList(userId,order),HttpStatus.OK);
    }
}
