package com.challenge.controller;

import com.challenge.dto.*;
import com.challenge.enums.SortingPostsEnum;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException {
        postService.addNewPost(request);
        return ResponseEntity.ok("Post added successfully");
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<RecentPostsResponse> getRecentPosts(@PathVariable Integer userId, @RequestParam(name = "order", required = false) SortingPostsEnum sorting) throws UserIdNotFoundException {
        return ResponseEntity.ok(postService.getRecentPosts(userId, sorting));
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody NewPromoPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException {
        postService.addNewPost(request);
        return ResponseEntity.ok("Promo post added successfully");
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ProductCountResponse> getPromoPostsCount(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(postService.getPromoPostsCount(userId));
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<DiscountPostsResponse> getAllPromoPosts(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(postService.getAllPromoPosts(userId));
    }

}
