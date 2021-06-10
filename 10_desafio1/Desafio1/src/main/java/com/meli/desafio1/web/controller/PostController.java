package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.dto.PromoPostDTO;
import com.meli.desafio1.web.exception.PostException;
import com.meli.desafio1.web.exception.PostUserNotFoundException;
import com.meli.desafio1.web.exception.UserNotFoundException;
import com.meli.desafio1.web.response.CountPromoPostResponse;
import com.meli.desafio1.web.response.PostListResponse;
import com.meli.desafio1.web.response.PromoPostListResponse;
import com.meli.desafio1.web.service.IPostService;
import com.meli.desafio1.web.service.PromoPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService ipostService;
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListResponse> getPosts(@PathVariable("userId") int userId, @RequestParam(value = "order", required = false, defaultValue = "date_desc") String order) throws PostException {
        return new ResponseEntity<>(ipostService.followedPostByUserId(userId,order), HttpStatus.OK);
    }

    @PostMapping("/newpost")
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO) throws Exception {
        ipostService.createPost(postDTO);
        return new ResponseEntity<>("todo OK", HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) throws Exception {
        ipostService.createPromoPost(promoPostDTO);
        return new ResponseEntity<>("todo OK", HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoPostResponse> countPromo(@PathVariable("userId") int userId) throws UserNotFoundException {
        return new ResponseEntity<>(ipostService.countPromo(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoPostListResponse> listPromo(@PathVariable("userId") int userId) throws UserNotFoundException {
        return new ResponseEntity<>(ipostService.listPromo(userId), HttpStatus.OK);
    }
}
