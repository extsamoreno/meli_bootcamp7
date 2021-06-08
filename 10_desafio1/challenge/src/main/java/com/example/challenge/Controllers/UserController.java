package com.example.challenge.Controllers;

import com.example.challenge.Exceptions.UserNoFoundException;
import com.example.challenge.Services.DTOs.FollowDTO;
import com.example.challenge.Services.DTOs.FollowerCountDTO;
import com.example.challenge.Services.DTOs.FollowersDTO;
import com.example.challenge.Services.DTOs.GetUserDTO;
import com.example.challenge.Services.IUserService;
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
    IUserService iUserService;

    @PostMapping("/users/{followerId}/follow/{followedID}")
    public ResponseEntity<FollowDTO> follow(@PathVariable int followerId, @PathVariable int followedID) throws UserNoFoundException {

        return new ResponseEntity<>(iUserService.follow(followerId, followedID), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<GetUserDTO>> getUsers() {

        return new ResponseEntity<>(iUserService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<FollowerCountDTO> getFollowersCont(@PathVariable int userId) throws UserNoFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCont(userId), HttpStatus.OK);
    }

    @PostMapping("/users/create/{userName}")
    public ResponseEntity<String> create(@PathVariable String userName) throws Exception {

        return new ResponseEntity<>(iUserService.addUser(userName), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers(@PathVariable int userId) throws UserNoFoundException {

        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.OK);

    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowersDTO> getFollowed(@PathVariable int userId) throws UserNoFoundException {

        return new ResponseEntity<>(iUserService.getFollowed(userId), HttpStatus.OK);

    }
}