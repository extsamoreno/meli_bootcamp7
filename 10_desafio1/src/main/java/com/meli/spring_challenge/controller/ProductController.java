package com.meli.spring_challenge.controller;

import com.meli.spring_challenge.exception.product.PostAlreadyExistException;
import com.meli.spring_challenge.exception.product.ProductIDAlreadyExistException;
import com.meli.spring_challenge.exception.user.UserNotFoundException;
import com.meli.spring_challenge.model.Post;
import com.meli.spring_challenge.service.dto.FollowedSellerCountDto;
import com.meli.spring_challenge.service.dto.FollowedSellerDto;
import com.meli.spring_challenge.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    //US 0005 - US 0010
    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void createNewPost(@RequestBody Post post) throws UserNotFoundException, PostAlreadyExistException, ProductIDAlreadyExistException {
        productService.createNewPost(post);
    }

    //US 0006 - US 0009
    @GetMapping("/followed/{userID}/list")
    public ResponseEntity<FollowedSellerDto> getFollowedSellerByID(@PathVariable int userID, @RequestParam(required = false) String order) throws UserNotFoundException {
        FollowedSellerDto result = productService.getFollowedSellerByID(userID, order);
        return new ResponseEntity<FollowedSellerDto>(result,HttpStatus.OK);
    }

    //US 0011
    @GetMapping("/{userID}/countPromo")
    public ResponseEntity<FollowedSellerCountDto> getFollowedSellerCount(@PathVariable int userID) throws UserNotFoundException {
        FollowedSellerCountDto result = productService.getFollowedSellerCount(userID);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //US 0012
    @GetMapping("/{userID}/list")
    public ResponseEntity<FollowedSellerDto> getFollowedSellerPromoByID(@PathVariable int userID) throws UserNotFoundException {
        FollowedSellerDto result = productService.getFollowedSellerPromoByID(userID);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
