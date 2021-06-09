package com.example.demo.controller;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PostListDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductServices productServices;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostDTO post) throws UserNotFoundException {
        productServices.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getPostList(@PathVariable Integer userId,@RequestParam(required = false, value = "order",defaultValue = "date_desc") String order){
        return new ResponseEntity<>(productServices.getPostList(userId,order),HttpStatus.OK);
    }


}
