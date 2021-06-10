package com.example.SocialMeli.Controllers;

import com.example.SocialMeli.Exceptions.*;

import com.example.SocialMeli.Services.DTOs.NonPromoPostDTO;
import com.example.SocialMeli.Services.DTOs.PostCountDTO;
import com.example.SocialMeli.Services.DTOs.PostDTO;
import com.example.SocialMeli.Services.DTOs.PromoPostDTO;
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
    public ResponseEntity<Void> makePost (@RequestBody NonPromoPostDTO postDTO) throws DateTimeParseException, ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException {

        iPostService.makePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/products/newpromopost")
    public ResponseEntity<Void> makePromoPost (@RequestBody PromoPostDTO postDTO) throws DateTimeParseException, ProductIdInUseException, PostIdInUseException, UserNotFoundException, PostNotFoundException {
        iPostService.makePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostDTO>> getFollowedPosts (@PathVariable int userId, @RequestParam(defaultValue="date_desc") String order) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        return new ResponseEntity<>(iPostService.getFollowedPost(userId, order) ,HttpStatus.OK);
    }

    @GetMapping("/products/{userId}/countPromo")
    public ResponseEntity<PostCountDTO> getUserPromPostCount (@PathVariable int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {
        return new ResponseEntity<>(iPostService.getPromPostsCant(userId) ,HttpStatus.OK);
    }
    @GetMapping("/products/{userId}/list")
    public ResponseEntity<List<PostDTO>> getUserPromPosts (@PathVariable int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {
        return new ResponseEntity<>(iPostService.getPromPostsByUser(userId) ,HttpStatus.OK);
    }
}
