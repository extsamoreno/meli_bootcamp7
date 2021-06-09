package com.example.SocialMeli.Controllers;

import com.example.SocialMeli.Exceptions.*;

import com.example.SocialMeli.Services.DTOs.PostDTO;
import com.example.SocialMeli.Services.iPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    iPostService iPostService;

    @PostMapping("/products/newpost")
    public ResponseEntity<Void> makePost (@RequestBody PostDTO postDTO) throws DateTimeParseException, ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException {

        iPostService.makePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostDTO>> getFollowedPosts (@PathVariable int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(iPostService.getFollowedPost(userId) ,HttpStatus.OK);
    }
}
