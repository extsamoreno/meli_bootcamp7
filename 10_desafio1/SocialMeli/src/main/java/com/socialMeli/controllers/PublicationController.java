package com.socialMeli.controllers;

import com.socialMeli.exceptions.FailCreatePostException;
import com.socialMeli.exceptions.InvalidDateException;
import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.PostsDTO;
import com.socialMeli.models.DTOs.PromoPostsCountDTO;
import com.socialMeli.models.DTOs.PromoPostsListDTO;
import com.socialMeli.models.PromoPost;
import com.socialMeli.models.StandardPost;
import com.socialMeli.models.Seller;
import com.socialMeli.services.iPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    iPublicationService service;

    @PostMapping("/newPost")
    public ResponseEntity<Void> newPost (@RequestBody StandardPost newPost) throws FailCreatePostException, InvalidDateException {
        return (new ResponseEntity<>(service.newPost(newPost), HttpStatus.OK));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsDTO> listPostFollowedSellers(@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(service.listPostFollowedSellers(userId), HttpStatus.OK));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<Seller> orderPostsByDate(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "") String order) throws UserNotFoundException, WrongCriteriaOrderException {
        return (new ResponseEntity<>(service.orderPostsByDate(userId, order), HttpStatus.OK));
    }

    @PostMapping("/newPromoPost")
    public ResponseEntity<Void> newPromoPost (@RequestBody PromoPost newPromoPost) throws FailCreatePostException, InvalidDateException {
        return (new ResponseEntity<>(service.newPromoPost(newPromoPost), HttpStatus.OK));
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoPostsCountDTO> countPromoPosts(@PathVariable Integer sellerId) throws UserNotFoundException {
        return (new ResponseEntity<>(service.countPromoPosts(sellerId), HttpStatus.OK));
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoPostsListDTO> listPromoPosts(@PathVariable Integer sellerId) throws UserNotFoundException {
        return (new ResponseEntity<>(service.listPromoPosts(sellerId), HttpStatus.OK));
    }

}
