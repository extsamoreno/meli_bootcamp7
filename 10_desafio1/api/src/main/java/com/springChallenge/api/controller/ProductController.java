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

    /**
     * Add a post to a given user in the payload
     * @param postDTO {@link PostDTO}
     * @throws UserNotFoundException if userId in invalid
     * @throws IDPostAlreadyUsed if idPost is already being used
     */
    @PostMapping("/newpost")
    public void createNewPost(@RequestBody PostDTO postDTO) throws UserNotFoundException, IDPostAlreadyUsed {
        iProductService.createNewPost(postDTO);
    }

    /**
     * Returns a {@link PostsListDTO} including all posts by followed users
     * @param userId the user to get the followed users from
     * @param order Optional, date_asc date_desc order by post date
     * @return a {@link PostsListDTO}
     * @throws UserNotFoundException if userId is incorrect
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsListDTO> getPostsByFollowed
            (@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "") String order)
            throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getPostsByFollowed(userId, order), HttpStatus.OK);
    }

    /**
     * Add a post to a given user in the payload
     * @param postDTO {@link PostDTO}
     * @throws UserNotFoundException if userId in invalid
     * @throws IDPostAlreadyUsed if idPost is already being used
     */
    @PostMapping("/newpromopost")
    public void createNewPromoPost(@RequestBody PostDTO postDTO) throws UserNotFoundException, IDPostAlreadyUsed{
        iProductService.createNewPost(postDTO);
    }

    /**
     * Returns a {@link CountPromoDTO} with the total count of promo posts for a given user
     * @param userId the id of the user to find the posts
     * @return a {@link CountPromoDTO}
     * @throws UserNotFoundException if user is invalid
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoDTO> getCountPromo(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getCountPromo(userId), HttpStatus.OK);
    }

    /**
     * Search for the promo posts by all sellers followed by an user
     * @param userId the id of the user to find the followed sellers
     * @return a {@link PostsListDTO}
     * @throws UserNotFoundException if user is invalid
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<PostsListDTO> getPromoPostsById(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iProductService.getPromoPostsById(userId), HttpStatus.OK);
    }
}
