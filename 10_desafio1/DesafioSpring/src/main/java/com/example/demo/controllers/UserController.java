package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @PostMapping("/add")        //CargarBD
    public void addUsers(){
         userService.addUsers();
         categoryService.addCategories();
         productService.addProducts();
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")   //US 0001
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserAlreadyFollowException, UserDoesntExistException {
            userService.follow(userId,userIdToFollow);
            return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")   //US 0002
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable int userId) throws UserDoesntExistException {
        return new ResponseEntity<>(userService.getFollowersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")     //US 0003 y US 0008
    public ResponseEntity<UserFollowerListDTO> getFollowerList(@PathVariable int userId, @RequestParam String order) throws UserDoesntExistException {
        return new ResponseEntity<>(userService.getFollowersList(userId,order),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")      //US 0004 y US 0008
    public ResponseEntity<UserFollowedListDTO> getFollowedList(@PathVariable int userId, @RequestParam String order) throws UserDoesntExistException {
        return new ResponseEntity<>(userService.getFollowedList(userId,order),HttpStatus.OK);
    }

    /*@PostMapping("/products/newpost")        //US 0005
    public ResponseEntity<NewPostResponseDTO> newPost(@RequestBody NewPostRequestDTO newPostRequestDTO) throws ParseException {
        return new ResponseEntity<>(userService.newPost(newPostRequestDTO),HttpStatus.CREATED);
    }*/

    /*@GetMapping("/products/followed/{userId}/list")     //US 0006 y US 0009
    public ResponseEntity<FollowedPostListResponseDTO> followedPostList(@PathVariable int userId,@RequestParam String order){
        return new ResponseEntity<>(userService.getFollowedPostList(userId,order),HttpStatus.CREATED);
    }*/

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")       //US 0007
    public ResponseEntity<UserResponseDTO> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        userService.unfollow(userId,userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }


}
