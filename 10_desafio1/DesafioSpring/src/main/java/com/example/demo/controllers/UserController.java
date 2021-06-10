package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.CantAutofollowException;
import com.example.demo.exceptions.CantUnfollowException;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDontFoundException;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @PostMapping("/load")        //CargarBD
    public void addUsers(){
         userService.addUsers();
         categoryService.addCategories();
         productService.addProducts();
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")   //US 0001
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserAlreadyFollowException, UserDontFoundException, CantAutofollowException {
            userService.follow(userId,userIdToFollow);
            return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")   //US 0002
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable int userId) throws UserDontFoundException {
        return new ResponseEntity<>(userService.getFollowersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")     //US 0003 y US 0008
    public ResponseEntity<UserFollowerListDTO> getFollowerList(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order) throws UserDontFoundException {
        return new ResponseEntity<>(userService.getFollowersList(userId,order),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")      //US 0004 y US 0008
    public ResponseEntity<UserFollowedListDTO> getFollowedList(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order) throws UserDontFoundException {
        return new ResponseEntity<>(userService.getFollowedList(userId,order),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")       //US 0007
    public ResponseEntity<UserResponseDTO> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserDontFoundException, CantUnfollowException {
        userService.unfollow(userId,userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }


}
