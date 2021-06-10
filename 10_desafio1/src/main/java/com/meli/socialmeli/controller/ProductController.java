package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.PostCollectionDTO;
import com.meli.socialmeli.dto.PostDTO;
import com.meli.socialmeli.dto.PromoPostsDTO;
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

    /**
     * Inserts a new standard post (non promo)
     *
     * @param postDTO The standard Post that want to be persisted
     * @throws InvalidIdException           If the userId entered does not correspond to an existing user
     * @throws PostIdAlreadyExistsException If the entered postId already exists
     */
    @PostMapping("/newpost")
    public ResponseEntity<Void> insertPost(@RequestBody PostDTO postDTO) throws InvalidIdException, PostIdAlreadyExistsException {

        productService.insertNewPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Inserts a new promo post
     *
     * @param postDTO The promo Post that want to be persisted
     * @throws InvalidIdException           If the userId entered does not correspond to an existing user
     * @throws PostIdAlreadyExistsException If the entered postId already exists
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> insertPromoPost(@RequestBody PostDTO postDTO) throws InvalidIdException, PostIdAlreadyExistsException {

        productService.insertNewPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Obtains all the posts published in the last 2 weeks by the sellers to which the entered user follows
     *
     * @param userId Corresponding to the user from whom you want to obtain the posts of his followed sellers
     * @param order  The chronological order in which you want to obtain the results. This order can be ascending or descending
     * @return The posts published in the last 2 weeks by the sellers to which the entered user follows, with the userId and userName of each seller
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PostCollectionDTO>> getFollowedMerchantsPosts(@PathVariable int userId, @RequestParam(required = false, defaultValue = "date_desc") String order) throws InvalidIdException {

        return new ResponseEntity<>(productService.getFollowedMerchantsPosts(userId, order), HttpStatus.OK);
    }

    /**
     * Obtains the number of promotional posts that a user has
     *
     * @param userId Corresponding to the user from whom you want to obtain the count of promotional posts
     * @return The count of promotional posts that a user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoPostsDTO> getMerchantNumberOfPromoPosts(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(productService.getMerchantNumberOfPromoPosts(userId), HttpStatus.OK);
    }

    /**
     * Obtains the list of the promotional posts that a user has
     *
     * @param userId Corresponding to the user from whom you want to obtain the promotional posts
     * @return A list of the promotional posts that a user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<PostCollectionDTO> getMerchantPromoPosts(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(productService.getMerchantPromoPosts(userId), HttpStatus.OK);
    }

}
