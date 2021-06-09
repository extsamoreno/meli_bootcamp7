package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.request.NewPostRequestDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialmeli/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<NewPostResponseDTO> addPost (@RequestBody NewPostRequestDTO newPost) throws InexistentUserException {
        return new ResponseEntity<>(productService.addPost (newPost), HttpStatus.OK);
    }
}
