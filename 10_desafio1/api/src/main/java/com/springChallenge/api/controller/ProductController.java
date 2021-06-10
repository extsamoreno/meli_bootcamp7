package com.springChallenge.api.controller;

import com.springChallenge.api.controller.dto.product.CountPromoDTO;
import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.controller.exception.product.IDPostAlreadyUsed;
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
    public void createNewPost(@RequestBody PostDTO postDTO) throws UserNotFoundException, IDPostAlreadyUsed {
        iProductService.createNewPost(postDTO);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsListDTO> getPostsByUserId
            (@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "") String order)
            throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getPostsByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public void createNewPromoPost(@RequestBody PostDTO postDTO) throws UserNotFoundException, IDPostAlreadyUsed{
        iProductService.createNewPost(postDTO);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoDTO> getCountPromo(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getCountPromo(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PostsListDTO> getPromoPostsById(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getPromoPostsById(userId), HttpStatus.OK);
    }
}
