package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.services.PostService;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/newpost")
    public void newPost(@RequestBody PostDTO post){
        postService.newPost(post);
    }


}
