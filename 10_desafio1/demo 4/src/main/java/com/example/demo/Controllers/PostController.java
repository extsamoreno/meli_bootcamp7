package com.example.demo.controllers;

import com.example.demo.DTO.ResponseCountPromosDTO;
import com.example.demo.DTO.ResponseListPromosDTO;
import com.example.demo.entities.Post;
import com.example.demo.DTO.ResponseGetPostsFollowedDTO;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity addPost(@RequestBody Post post) throws Exception {
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseGetPostsFollowedDTO> getPostsFollowed(@PathVariable int userId, @RequestParam(required = false) String order) throws Exception {
        ResponseGetPostsFollowedDTO response = postService.getPostsFollowed(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity newPromoPost(@RequestBody Post post) throws Exception {
        postService.addPost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ResponseCountPromosDTO> countPromos(@PathVariable int userId) throws Exception {
        ResponseCountPromosDTO response = postService.promosByUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<ResponseListPromosDTO> listPromos(@PathVariable int userId) throws Exception {
        ResponseListPromosDTO response = postService.listPromosByUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
