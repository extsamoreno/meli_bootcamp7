package com.reto1.demo.Controller;

import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    IFollowService iFollowService;

    //Create a post
    @PostMapping("/products/newpost")
    public ResponseEntity<String> createPost(@RequestBody Post post) throws UserIdNotFoundException {
        String postname = iFollowService.creatPost(post);
        return new ResponseEntity<>("The post " + postname + " was created", HttpStatus.OK);
    }
    
}





