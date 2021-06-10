package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.*;
import com.example.DesafioSpring.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/products")
public class PostControllers {
    @Autowired
    IPostService iPostService;

    //Requerimiento 5
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody NoPromoDTO postDTO) throws DateTimeParseException, ProductTakenException, PostTakenException, UserNotFoundException, PostNotFoundException {

        iPostService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Requerimiento 10
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@RequestBody PromoPostDTO postDTO) throws DateTimeParseException, ProductTakenException, PostTakenException, UserNotFoundException, PostNotFoundException {
        iPostService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Requerimiento 6 y 9
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsConstructorDTO> getFollowedByPosts(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(iPostService.getFollowedByPost(userId, order), HttpStatus.OK);
    }

    //Requerimiento 11
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PostCounterDTO> postWithPromo(@PathVariable int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {
        return new ResponseEntity<>(iPostService.postWithPromo(userId), HttpStatus.OK);
    }

    //Requerimiento 12
    @GetMapping("{userId}/list")
    public ResponseEntity<PostsConstructorDTO> sellerPromoList(@PathVariable int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {
        return new ResponseEntity<>(iPostService.sellerPromoList(userId), HttpStatus.OK);
    }
}
