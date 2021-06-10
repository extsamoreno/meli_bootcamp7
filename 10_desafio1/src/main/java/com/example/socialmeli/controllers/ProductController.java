package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.request.NewPromoPostRequestDTO;
import com.example.socialmeli.models.dtos.response.*;
import com.example.socialmeli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * SocialMeli REST API - ProductController
 *
 * @author Macarena Agostina Pomerantz
 */

@RestController
@RequestMapping("/socialmeli/products")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Adds a new post to a user
     *
     * @param newPost the post and userId in which you want to add the post
     * @return the status and message of success in follow request
     * @throws InexistentUserException if the user does not exist in the local repository
     * @throws ExistentPostException if the post is already added to the user
     */

    @PostMapping("/newpost")
    public ResponseEntity<NewPostResponseDTO> addPost (@RequestBody NewPostRequestDTO newPost) throws InexistentUserException, ExistentPostException, InvalidDatePostException {
        return new ResponseEntity<>(productService.addPost (newPost), HttpStatus.OK);
    }

    /**
     * Lists last 2 weeks posts of followed users
     *
     * @param userId the userId of the user you want to lists its last 2 weeks followed posts
     * @param order the order type of the response. It can be "date_asc" or "date_desc". If nothing is sent, default value is set to "date_asc"
     * @return the userId of the user and its last 2 weeks followed users posts
     * @throws InexistentUserException if the user does not exist in the local repository
     * @throws InexistentDateOrderException if the order provided is not valid and it is not "date_asc" or "date_desc"
     */

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListFollowedPostsResponseDTO> listPosts (@PathVariable int userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws InexistentUserException, InexistentDateOrderException {
        return new ResponseEntity<>(productService.listPosts(userId, order), HttpStatus.OK);
    }

    /**
     * Adds a new promo post to a user
     *
     * @param newPost the promo post and userId in which you want to add the promo post
     * @return the status and message of success in follow request
     * @throws InexistentUserException if the user does not exist in the local repository
     * @throws ExistentPromoPostException if the promo post is already added to the user
     * @throws InvalidPromoPostException if the promo post is not sent as a promo post
     */

    @PostMapping("/newpromopost")
    public ResponseEntity<NewPostResponseDTO> addPromoPost (@RequestBody NewPromoPostRequestDTO newPost) throws InexistentUserException, ExistentPromoPostException, InvalidPromoPostException, InvalidDatePostException {
        return new ResponseEntity<>(productService.addPromoPost (newPost), HttpStatus.OK);
    }

    /**
     * Counts promo posts
     *
     * @param userId the userId of the user to count its promo post
     * @return the userId and userName of the user and its quantity of promo posts
     * @throws InexistentUserException if the user does not exist in the local repository
     */

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<SellerPromoProductsCountResponseDTO> countPromoProducts (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(productService.countPromoProducts(userId), HttpStatus.OK);
    }

    /**
     * Lists user promo post
     *
     * @param userId the userId of the user to list its promo post
     * @return the userId and userName of the user and a list of its promo posts
     * @throws InexistentUserException if the user does not exist in the local repository
     */

    @GetMapping("/{userId}/list")
    public ResponseEntity<ListSellerPromoProductsDTO> listPromoProducts (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(productService.listPromoProducts(userId), HttpStatus.OK);
    }
}
