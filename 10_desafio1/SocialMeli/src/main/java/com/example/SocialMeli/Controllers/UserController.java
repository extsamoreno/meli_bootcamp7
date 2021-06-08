package com.example.SocialMeli.Controllers;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.FollowCountDTO;
import com.example.SocialMeli.Services.DTOs.FollowDTO;
import com.example.SocialMeli.Services.DTOs.FollowedDTO;
import com.example.SocialMeli.Services.DTOs.FollowersDTO;
import com.example.SocialMeli.Services.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    iUserService iUserService;
    @PostMapping("/users/{followerId}/follow/{followedID}")
    public ResponseEntity<FollowDTO> follow (@PathVariable String followerId, @PathVariable String followedID) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.follow(followerId, followedID), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowCountDTO> getFollowersCount (@PathVariable String userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers (@PathVariable String userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed (@PathVariable String userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowed(userId), HttpStatus.OK);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> follow (){

        return new ResponseEntity<>(iUserService.getdb(), HttpStatus.OK);
    }
}
