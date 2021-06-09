package meli.springchallenge.controllers;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.FollowedPostDTO;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
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
    public ResponseEntity<String> createPost(@RequestBody PostDTO post) throws PostIdNotValidException, ProductIdNotValidException, UserNotValidException {
        productService.createPost(post);
        return new ResponseEntity("New post successfully added", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostDTO> getFollowedPosts(@PathVariable int userId, @RequestParam(defaultValue = "date_desc") String order) throws UserNotValidException {
        return new ResponseEntity<FollowedPostDTO>(productService.getFollowedPosts(userId, order),HttpStatus.OK);
    }


}
