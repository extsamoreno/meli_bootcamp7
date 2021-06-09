package com.springChallenge.api.controller;

import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.service.contract.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    public void createNewPost(@RequestBody PostDTO postDTO) throws UserNotFoundException {
        iProductService.createNewPost(postDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsListDTO> getPostsByUserId(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getPostsByUserId(userId), HttpStatus.OK);
    }
}
