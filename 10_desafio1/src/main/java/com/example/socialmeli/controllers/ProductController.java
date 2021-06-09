package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.InexistentDateOrderException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.request.NewPromoPostRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowersCountResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.models.dtos.response.SellerPromoProductsCountResponseDTO;
import com.example.socialmeli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socialmeli/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<NewPostResponseDTO> addPost (@RequestBody NewPostRequestDTO newPost) throws InexistentUserException {
        return new ResponseEntity<>(productService.addPost (newPost), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListFollowedPostsResponseDTO> listPosts (@PathVariable int userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws InexistentUserException, InexistentDateOrderException {
        return new ResponseEntity<>(productService.listPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> addPost (@RequestBody NewPromoPostRequestDTO newPost) throws InexistentUserException {
        return new ResponseEntity<>(productService.addPromoPost (newPost), HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<SellerPromoProductsCountResponseDTO> countPromoProducts (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(productService.countPromoProducts(userId), HttpStatus.OK);
    }
}
