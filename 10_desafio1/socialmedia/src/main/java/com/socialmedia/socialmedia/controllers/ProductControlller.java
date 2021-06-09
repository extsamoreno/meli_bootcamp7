package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.exceptions.PostInsertException;
import com.socialmedia.socialmedia.exceptions.ProductInsertException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.services.IProductService;
import com.socialmedia.socialmedia.services.dtos.PostDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedPostsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControlller {

    @Autowired
    private IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> addNewProductWithPost(@RequestBody PostDTO postDTO) throws ProductInsertException, PostInsertException {
        productService.addNewProductWithPost(postDTO);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserWithFollowedPostsDTO> getFollowedPostsByUser(@PathVariable int userId) throws UserNotFoundException {
        UserWithFollowedPostsDTO userWithFollowedPostsDTO = productService.getFollowedPostsByUser(userId);

        return new ResponseEntity<>(userWithFollowedPostsDTO, HttpStatus.OK);
    }
}
