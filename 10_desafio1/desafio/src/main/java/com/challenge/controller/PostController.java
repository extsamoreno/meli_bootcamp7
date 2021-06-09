package com.challenge.controller;

import com.challenge.dto.NewPostRequest;
import com.challenge.dto.NewPromoPostRequest;
import com.challenge.dto.PostDTO;
import com.challenge.entity.Post;
import com.challenge.enums.SortingPostsEnum;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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
    public ResponseEntity<List<PostDTO>> getRecentPosts(@PathVariable Integer userId, @RequestParam(name = "order", required = false) SortingPostsEnum sorting) throws UserIdNotFoundException {
        return ResponseEntity.ok(postService.getRecentPosts(userId, sorting));
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody NewPromoPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException {
        postService.addNewPost(request);
        return ResponseEntity.ok("Promo post added successfully");
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<Integer> getPromoPostsCount(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(postService.getPromoPostsCount(userId));
    }



}
