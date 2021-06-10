package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.IPostService;
import com.meli.socialmeli.service.dto.PostDTOAllPostList;
import com.meli.socialmeli.service.dto.PostDTOFollowedList;
import com.meli.socialmeli.service.dto.PostDTOPromoCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    IPostService iPostService;

    /**
     * This is the US 0005 Endpoint, which enable the option to register
     * a new post
     * @param post -> the complete post with user id, id post, date, detail,
     *             category and price. Its mapped for an post request
     * @return -> an OK status if all is correct, BAD_REQUEST if not
     * @throws MissingDataException -> If detail or date are null values
     * @throws UserNotFoundException -> If the user id included in the post
     * hasn't been found
     * @throws PostIdAlreadyExistException -> If the post id is already
     * used on a different post
     * @throws OverActualDateException -> If the date included in the post
     * is over the actual date
     */
    @PostMapping("/products/newpost")
    public ResponseEntity<HttpStatus> addNewPost(@RequestBody Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        HttpStatus status= iPostService.addNewPost(post);
        return new ResponseEntity<>(status, status);
    }

    /**
     * This is the US 0006/0009 Endpoint, which enable the option to get a list of
     * the post made by the followed sellers with a maximum antiquity of 2 weeks ago
     * @param userId -> the id of the user to get his followed sellers
     * @param order -> Optional parameter which allows the user to choose a sort order
     * @return -> the user id and a list of followed post sorted by desc by default
     * @throws IncorrectOrderTypeException
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostDTOFollowedList> getFollowedUserPosts(@PathVariable int userId, @RequestParam(required = false) String order) throws IncorrectOrderTypeException {
        return new ResponseEntity<>(iPostService.getFollowedUserPosts(userId, order),HttpStatus.OK);
    }

    /**
     * This is the US 0010 Endpoint, which enable the option to register a new promotion
     * post
     * @param post -> the complete post with user id, id post, date, detail,
     *             category and price. Its mapped for an post request
     * @return -> an OK status if all is correct, BAD_REQUEST if not
     * @throws MissingDataException -> If detail or date are null values
     * @throws UserNotFoundException -> If the user id included in the post
     * hasn't been found
     * @throws PostIdAlreadyExistException -> If the post id is already
     * used on a different post
     * @throws OverActualDateException -> If the date included in the post
     * is over the actual date
     */
    @PostMapping("/products/newpromopost")
    public ResponseEntity<HttpStatus> addNewPromotionPost(@RequestBody Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException {
        HttpStatus status= iPostService.addNewPromotionPost(post);
        return new ResponseEntity<>(status, status);
    }

    /**
     * This is the US 0011 Endpoint, which enable the option to get the promotion
     * posts count of an specific seller
     * @param userId -> the id of the seller
     * @return -> the seller id (as userId), the seller name (as userName) and
     * the promotion posts count
     * @throws UserNotFoundException -> If the user id hasn't been found
     */
    @GetMapping("/products/{userId}/countPromo")
    public ResponseEntity<PostDTOPromoCount> getPostPromoCount(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iPostService.getPostPromoCount(userId),HttpStatus.OK);
    }

    /**
     * This is the US 0012 Endpoint, which enable the option to get a list of all
     * promotion posts of an specific seller
     * @param userId -> the id of the seller
     * @return -> the seller id (as userId), the seller name (as userName) and
     * a list of all his promotion posts
     * @throws UserNotFoundException
     */
    @GetMapping("/products/{userId}/list")
    public ResponseEntity<PostDTOAllPostList> getAllPromotionPost(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iPostService.getAllPromotionPost(userId),HttpStatus.OK);
    }

}
