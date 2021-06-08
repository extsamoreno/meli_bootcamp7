package com.meli.spring_challenge.controller;

import com.meli.spring_challenge.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void createNewPost(@RequestBody Post post){

    }

}
