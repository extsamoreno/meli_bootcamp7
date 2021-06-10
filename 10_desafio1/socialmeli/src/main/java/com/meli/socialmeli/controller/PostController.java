package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.service.IPostService;
import com.meli.socialmeli.service.dto.PostDTO;
import com.meli.socialmeli.service.dto.PostFollowingDTO;
import com.meli.socialmeli.service.dto.ProductsUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> addPost(@RequestBody PostDTO postDTO) throws PostDateBeforeToday, UserNotExistsException, PostAlreadyExists, PostNotExistsException {
        postService.addPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/following/{userId}/list")
    public ResponseEntity<PostFollowingDTO> getListPostUsersFollowingByUserId(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_desc") String order) throws MissingParameterException, UserNotExistsException {
        return new ResponseEntity<>(postService.getListPostUsersFollowingByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<Void> addPromoPost(@RequestBody PostDTO postDTO) throws PostDateBeforeToday, UserNotExistsException, PostAlreadyExists, PostNotExistsException {
        postService.addPromoPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo/")
    public ResponseEntity<Integer> countPromoProductsByUserId(@PathVariable int userId) throws UserNotExistsException {
        return new ResponseEntity<>(postService.countProductPromoByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<ProductsUserDTO> getListPromoPostByUserId(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_desc") String order) throws UserNotExistsException {
        return new ResponseEntity<>(postService.getProductsPromoPostByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/updatepost")
    public ResponseEntity<Void> updatePost(@RequestBody PostDTO postDTO) throws PostDateBeforeToday, PostNotExistsException {
        postService.updatePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}