package com.example.desafiospring.socialmeli.controller;

import com.example.desafiospring.socialmeli.service.IUserService;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId , @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        userService.followUser(userId,userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDTO> getUserFollowersCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getUserFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getUserFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowed(userId),HttpStatus.OK);
    }

}
