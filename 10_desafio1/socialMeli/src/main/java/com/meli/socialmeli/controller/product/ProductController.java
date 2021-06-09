package com.meli.socialmeli.controller.product;

import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.product.PublicationWithPromoDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.service.orderType.PublicationOrderType;
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
    public ResponseEntity<FollowedPublicationDTO> followedPublications(@PathVariable Integer userId,@RequestParam(required = false) PublicationOrderType order) throws IdNotFoundException {
        return new ResponseEntity<>(productService.followedRecentPublications(userId,order), HttpStatus.OK);
    }
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> createNewPostWithPromo(@RequestBody PublicationWithPromoDTO body) throws CanNotCreatePostException, InvalidDateFormatException {
        productService.createPostWithPromo(body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
