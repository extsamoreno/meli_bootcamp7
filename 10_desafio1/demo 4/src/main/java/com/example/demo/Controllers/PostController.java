package com.example.demo.Controllers;

import com.example.demo.Entities.Post;
import com.example.demo.Services.DTO.ResponseGetPostsFollowedDTO;
import com.example.demo.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<ResponseGetPostsFollowedDTO> getPostsFollowed(@PathVariable int userId,  @RequestParam(required = false) String order) throws Exception {
        ResponseGetPostsFollowedDTO response = postService.getPostsFollowed(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
