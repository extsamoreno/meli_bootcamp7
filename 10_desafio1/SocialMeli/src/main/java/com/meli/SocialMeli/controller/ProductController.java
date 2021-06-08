package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.PostDto;
import com.meli.SocialMeli.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping(path = "/newpost")
    public ResponseEntity<String> newPost(@RequestBody PostDto postDto) throws ParseException {
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
