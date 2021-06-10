package com.desafiospring.socialMeli.controller;

import com.desafiospring.socialMeli.dto.request.NewPostDTO;
import com.desafiospring.socialMeli.dto.request.NewPromoPostDTO;
import com.desafiospring.socialMeli.dto.response.FollowedPostDTO;
import com.desafiospring.socialMeli.dto.response.PromoPostCountDTO;
import com.desafiospring.socialMeli.dto.response.PromoPostListDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostsController {

    @Autowired
    IPostService postService;

    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody NewPostDTO postDTO)
            throws UserNotFoundException, PostIdAlreadyExistException {
        postService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostDTO> getRecentPostsList(@PathVariable int userId,
                                                              @RequestParam(required = false) String order)
            throws UserNotFoundException {
        return new ResponseEntity<>(postService.getFollowedRecentPosts(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity newPromoPost(@RequestBody NewPromoPostDTO promoPostDto)
            throws UserNotFoundException, PostIdAlreadyExistException {
        postService.newPromoPost(promoPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCount(@PathVariable int userId)
            throws UserNotFoundException {
        return new ResponseEntity(postService.getPromoPostCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoPostListDTO> getPromoPostsList(@PathVariable int userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPromoPostsList(userId), HttpStatus.OK);
    }


}
