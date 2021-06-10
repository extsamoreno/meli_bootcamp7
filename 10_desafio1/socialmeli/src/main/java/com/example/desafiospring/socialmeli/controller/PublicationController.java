package com.example.desafiospring.socialmeli.controller;

import com.example.desafiospring.socialmeli.exception.DateIsNotValidException;
import com.example.desafiospring.socialmeli.exception.PostIdAlreadyExistException;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;
import com.example.desafiospring.socialmeli.service.DTO.PostListDTO;
import com.example.desafiospring.socialmeli.service.DTO.PromoPostDTO;
import com.example.desafiospring.socialmeli.service.DTO.PromoUserProductDTO;
import com.example.desafiospring.socialmeli.service.IPostService
import com.example.desafiospring.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
/**
 * 0005 - mapping products
 */
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    IPostService IPostService;
    private Object post;
    private Object PostDTO;

    /**
     * 0005 post the newpost
     */
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody Post post) throws UserNotFoundException {
        IPostService.newPost(post); //
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * 0006 - get
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getFollowedPostList(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(
                IPostService.getFollowedPostList(userId), HttpStatus.OK
        ); /**
         * 0009
         */
    }

    /**
     * 0010
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@RequestBody PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        IPostService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 0011
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoUserProductDTO> getPromoProductsCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity(
                IPostService.getProductPost(userId),HttpStatus.OK
        );
    }

    /**
     * 0012
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<PostListDTO> listPromoPosts(@PathVariable Integer sellerId) throws UserNotFoundException {
        return (new ResponseEntity(IUserService.PostList(sellerId), HttpStatus.OK));
    }

}