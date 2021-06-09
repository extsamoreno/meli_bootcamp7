package com.example.demo.controller;

import com.example.demo.DTO.FollowedListDTO;
import com.example.demo.DTO.FollowersCountDTO;
import com.example.demo.DTO.FollowersListDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserServices userServices;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        userServices.follow(userId,userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> followersCount (@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userServices.countFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followers/list")
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable Integer UserID) throws UserNotFoundException {
        return new ResponseEntity<>(userServices.followersList(UserID),HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followed/list")
    public ResponseEntity<FollowedListDTO> followedList (@PathVariable Integer UserID) throws UserNotFoundException {
        return new ResponseEntity<>(userServices.followedList(UserID),HttpStatus.OK);
    }

}
