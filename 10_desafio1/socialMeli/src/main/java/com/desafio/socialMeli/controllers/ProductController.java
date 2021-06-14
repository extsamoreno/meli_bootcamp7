package com.desafio.socialMeli.controllers;

import com.desafio.socialMeli.model.dao.models.Post;
import com.desafio.socialMeli.model.dto.UserFollowedPostsDTO;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;
import com.desafio.socialMeli.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;


    @PostMapping("/newpost")
    public ResponseEntity<String> saveNewPost(@RequestBody Post post) throws UserNotFoundException {
        return new ResponseEntity<String>(iProductService.saveNewPost(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserFollowedPostsDTO> getFollowedPostsByUser(@PathVariable int userId) throws UserNotFoundException, RepositoryUnableException {
        UserFollowedPostsDTO userWithFollowedPostsDTO = iProductService.getFollowedPostsByUser(userId);
        return new ResponseEntity<>(userWithFollowedPostsDTO, HttpStatus.OK);
    }
/*
    @GetMapping("/{UserID}/followers/list")
    public ResponseEntity<UserFollowedPostsDTO> getListOfFollowers(@PathVariable int userId @RequestParam(name = "order", required = false, defaultValue = "name_asc") String order){
        UserFollowedPostsDTO userWithFollowedPostsDTO = iProductService.getListOfFollowers(userId);
        return new ResponseEntity<>(userWithFollowedPostsDTO, HttpStatus.OK);
    }*/
}