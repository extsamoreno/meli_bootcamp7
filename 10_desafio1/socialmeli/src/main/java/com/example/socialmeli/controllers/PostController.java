package com.example.socialmeli.controllers;

import com.example.socialmeli.dtos.post.PostListDTO;
import com.example.socialmeli.dtos.post.PromoCountDTO;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.postExceptions.MissingDataException;
import com.example.socialmeli.exceptions.postExceptions.PostAlreadyExistException;
import com.example.socialmeli.models.Post;
import com.example.socialmeli.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    /**
     * Create a Post
     */
    @PostMapping("/products/newpost")
    public ResponseEntity<HttpStatus> newPost(@RequestBody Post post) throws UserNotFoundException, PostAlreadyExistException, MissingDataException {
        return new ResponseEntity<>(postService.newPost(post),HttpStatus.CREATED);
    }

    /**
     *
     * @param userId
     * @param name
     * @param order
     * @return PostListDTO (List of posts by id order asc or desc)
     * @throws UserNotFoundException
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostListDTO> postList(@PathVariable Integer userId,
                                                @RequestParam(required = false, defaultValue = "") String name,
                                                @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<PostListDTO>(postService.getPostByUserId(userId,name, order),HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @return PromoCountDTO (count of post with promo)
     * @throws UserNotFoundException
     * @throws MerchantNotFoundException
     */
    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<PromoCountDTO> promoCount(@PathVariable Integer userId) throws UserNotFoundException, MerchantNotFoundException {
        return new ResponseEntity<PromoCountDTO>(postService.promoCount(userId),HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @return PostListDTO (list of post by id with promo)
     * @throws MerchantNotFoundException
     */
    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<PostListDTO> listPromoProductsByUserid(@PathVariable Integer userId) throws MerchantNotFoundException {
        return new ResponseEntity<PostListDTO>(postService.listPromoProductsByUserid(userId),HttpStatus.OK);
    }
}