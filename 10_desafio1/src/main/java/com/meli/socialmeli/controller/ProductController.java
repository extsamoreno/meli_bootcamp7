package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.PostCollectionDTO;
import com.meli.socialmeli.dto.PostDTO;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.PostIdAlreadyExistsException;
import com.meli.socialmeli.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> insertPost(@RequestBody PostDTO postDTO) throws InvalidIdException, PostIdAlreadyExistsException {

        productService.insertNewPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostCollectionDTO>> getFollowedMerchantsPosts(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(productService.getFollowedMerchantsPosts(userId), HttpStatus.OK);
    }
}
