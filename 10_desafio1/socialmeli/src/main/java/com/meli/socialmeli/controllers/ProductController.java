package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dto.UserPostListDTO;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.UserMeli;
import com.meli.socialmeli.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IPostService iPostService;
    //Punto 5 Listo
    @PostMapping("/newpost")
    public ResponseEntity<UserMeli> SetNewPost(@RequestBody Post post){
        Post post1 = new Post();
        return new ResponseEntity<>(iPostService.newPost(post), HttpStatus.OK);
    }
    //Punto 6 Listo
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostListDTO> getListPost(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order){

        return new ResponseEntity<>(iPostService.getListPosts(userId, order), HttpStatus.OK);
    }
}
