package com.meli.socialmeli.controller.product;

import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> createNewPost(@RequestBody PublicationDTO body) throws CanNotCreatePostException, InvalidDateFormatException {
        productService.createPost(body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPublicationDTO> followedPublications(@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(productService.followedRecentPublications(userId), HttpStatus.OK);
    }

}
