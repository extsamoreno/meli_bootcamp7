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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    iUserService iUserService;



    @PostMapping("/users/{followerId}/unfollow/{followedId}")
    public ResponseEntity<FollowDTO> unfollow (@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.unfollow(followerId, followedId), HttpStatus.OK);
    }


    @PostMapping("/users/{followerId}/follow/{followedId}")
    public ResponseEntity<FollowDTO> follow (@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.follow(followerId, followedId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowCountDTO> getFollowersCount (@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers (@RequestParam(defaultValue="name_asc") String order ,@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed (@RequestParam(defaultValue="name_asc") String order ,@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowed(userId, order), HttpStatus.OK);
    }

}
