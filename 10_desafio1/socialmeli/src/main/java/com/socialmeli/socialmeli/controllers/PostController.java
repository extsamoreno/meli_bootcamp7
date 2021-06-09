package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.PostService;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException, ParseException {
        System.out.println(post);
        postService.newPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
