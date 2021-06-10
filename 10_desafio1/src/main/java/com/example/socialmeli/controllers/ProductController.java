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

@RestController
@RequestMapping("/socialmeli/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<NewPostResponseDTO> addPost (@RequestBody NewPostRequestDTO newPost) throws InexistentUserException, ExistentPostException {
        return new ResponseEntity<>(productService.addPost (newPost), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListFollowedPostsResponseDTO> listPosts (@PathVariable int userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws InexistentUserException, InexistentDateOrderException {
        return new ResponseEntity<>(productService.listPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<NewPostResponseDTO> addPromoPost (@RequestBody NewPromoPostRequestDTO newPost) throws InexistentUserException, ExistentPromoPostException, InvalidPromoPostException {
        return new ResponseEntity<>(productService.addPromoPost (newPost), HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<SellerPromoProductsCountResponseDTO> countPromoProducts (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(productService.countPromoProducts(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<ListSellerPromoProductsDTO> listPromoProducts (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(productService.listPromoProducts(userId), HttpStatus.OK);
    }
}
