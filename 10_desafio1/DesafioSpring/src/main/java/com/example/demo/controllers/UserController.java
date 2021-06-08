package com.example.demo.controllers;

import com.example.demo.dtos.UserFollowedListDTO;
import com.example.demo.dtos.UserFollowerListDTO;
import com.example.demo.dtos.UserFollowersCountDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.UserAlreadyFollowException;
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

    @PostMapping("/add")
    public void addUsers(){
         userService.addUsers();
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserAlreadyFollowException {
            userService.follow(userId,userIdToFollow);
            return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserResponseDTO> unfollow(@PathVariable int userId,int userIdToUnfollow){
        userService.unfollow(userId,userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable int userId){
        return new ResponseEntity<>(userService.followersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerListDTO> getFollowerList(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowersList(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDTO> getFollowedList(@PathVariable int userId){
        return new ResponseEntity<>(userService.getFollowedList(userId),HttpStatus.OK);
    }



}
