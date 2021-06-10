package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.services.IProductService;
import com.socialmedia.socialmedia.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductControlller {

    @Autowired
    private IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> addNewProductWithPost(@RequestBody PostDTO postDTO) throws ProductInsertException, PostInsertException, ObjectExistException, ObjectNotFoundException {
        productService.addNewProductWithPost(postDTO);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<Void> addNewProductPromoWithPost(@RequestBody PostPromoDTO postPromoDTO) throws ProductInsertException, PostInsertException, ObjectExistException, ObjectNotFoundException {
        productService.addNewProductPromoWithPost(postPromoDTO);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserWithFollowedPostsDTO> getFollowedPostsByUser(@PathVariable int userId, @RequestParam(value = "order", defaultValue = "date_asc") String order)
            throws UserNotFoundException, ObjectNotFoundException, UserDistinctTypeException {
        UserWithFollowedPostsDTO userWithFollowedPostsDTO = productService.getFollowedPostsByUser(userId, order);

        return new ResponseEntity<>(userWithFollowedPostsDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<UserCountPromoDTO> getCountPromosByUser(@PathVariable int userId) throws UserDistinctTypeException, ObjectNotFoundException {
        UserCountPromoDTO result = productService.getCountPromosByUser(userId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<UserWithPromosDTO> getPromosByUser(@PathVariable int userId) throws UserDistinctTypeException, ObjectNotFoundException {
        UserWithPromosDTO result = productService.getPromosByUser(userId);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
