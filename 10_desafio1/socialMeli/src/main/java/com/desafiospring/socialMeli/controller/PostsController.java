package com.desafiospring.socialMeli.controller;

import com.desafiospring.socialMeli.dto.FollowedPostDTO;
import com.desafiospring.socialMeli.dto.PostDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostsController {

    @Autowired
    IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostDTO postDTO)
            throws UserNotFoundException, PostIdAlreadyExistException {
        productService.newPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostDTO> getPostList(@PathVariable int userId,
                                                       @RequestParam(required = false) String order)
            throws UserNotFoundException {
        return new ResponseEntity<>(productService.getFollowedPosts(userId, order), HttpStatus.OK);
    }


}
