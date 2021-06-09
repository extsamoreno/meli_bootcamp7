package com.example.demo.controller;

import com.example.demo.services.IUserServices;
import com.example.demo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserServices userServices;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Boolean> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userServices.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable int userId){
        return new ResponseEntity<>(userServices.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable int userId){
        return new ResponseEntity<>(userServices.getFollowersList(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable int userId){
        return new ResponseEntity<>(userServices.getFollowedList(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(userServices.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }


}
