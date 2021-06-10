package com.socialMeli.controllers;

import com.socialMeli.exceptions.FailCreatePostException;
import com.socialMeli.exceptions.InvalidDateException;
import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.PostsDTO;
import com.socialMeli.models.DTOs.PromoPostsCountDTO;
import com.socialMeli.models.DTOs.PromoPostsListDTO;
import com.socialMeli.models.Post;
import com.socialMeli.models.PromoPost;
import com.socialMeli.services.iPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    iPublicationService publicationService;

    @PostMapping("/newPost")
    public ResponseEntity<Void> newPost (@RequestBody Post newPost) throws FailCreatePostException, InvalidDateException {
        return (new ResponseEntity<>(publicationService.newPost(newPost), HttpStatus.OK));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsDTO> listPostFollowedSellers(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "", required = false) String order) throws UserNotFoundException, WrongCriteriaOrderException {
        return (new ResponseEntity<>(publicationService.listPostFollowedSellers(userId, order), HttpStatus.OK));
    }

    @PostMapping("/newPromoPost")
    public ResponseEntity<Void> newPromoPost (@RequestBody PromoPost newPromoPost) throws FailCreatePostException, InvalidDateException {
        return (new ResponseEntity<>(publicationService.newPromoPost(newPromoPost), HttpStatus.OK));
    }

    @GetMapping("/{sellerId}/countPromo")
    public ResponseEntity<PromoPostsCountDTO> countPromoPosts(@PathVariable Integer sellerId) throws UserNotFoundException {
        return (new ResponseEntity<>(publicationService.countPromoPosts(sellerId), HttpStatus.OK));
    }

    @GetMapping("/{sellerId}/list")
    public ResponseEntity<PromoPostsListDTO> listPromoPosts(@PathVariable Integer sellerId) throws UserNotFoundException {
        return (new ResponseEntity<>(publicationService.listPromoPosts(sellerId), HttpStatus.OK));
    }

}
