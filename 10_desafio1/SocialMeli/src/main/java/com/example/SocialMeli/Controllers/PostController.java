package com.example.SocialMeli.Controllers;

import com.example.SocialMeli.Exceptions.UserNotFoundException;

import com.example.SocialMeli.Services.DTOs.PostDTO;
import com.example.SocialMeli.Services.iPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    iPostService iPostService;

    @PostMapping("/products/newpost")
    public ResponseEntity<Boolean> makePost (@RequestBody PostDTO postDTO) throws UserNotFoundException {

        iPostService.makePost(postDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
