package meli.springchallenge.controllers;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.followedPostDTO;
import meli.springchallenge.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsControler {

    @Autowired
    IProductService productService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity("pong", HttpStatus.OK);
    }

    @PostMapping("/newpost")
    public ResponseEntity<String> createPost(@RequestBody PostDTO post){
        productService.createPost(post);
        return new ResponseEntity("New post successfully added", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<followedPostDTO> getFollowedPosts(@PathVariable int UserId){
        return new ResponseEntity<followedPostDTO>(productService.getFollowedPosts(UserId),HttpStatus.OK);
    }


}
