package com.example.desafio_1.controller;

import com.example.desafio_1.exception.UserExceptionAlreadyFollowed;
import com.example.desafio_1.exception.UserExceptionNotFound;
import com.example.desafio_1.exception.UserExceptionWrongType;
import com.example.desafio_1.service.IUserService;
import com.example.desafio_1.service.dto.UserDTO;
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
    public ResponseEntity<Void> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserExceptionWrongType, UserExceptionNotFound, UserExceptionAlreadyFollowed {
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDTO> followersCount(@PathVariable int userId) throws UserExceptionNotFound, UserExceptionWrongType {
        return new ResponseEntity<UserDTO>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> followersList(@PathVariable int userId) throws UserExceptionNotFound, UserExceptionWrongType {
        return new ResponseEntity<UserDTO>(userService.getFollowersList(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> followingList(@PathVariable int userId) throws UserExceptionNotFound, UserExceptionWrongType {
        return new ResponseEntity<UserDTO>(userService.getFollowingList(userId), HttpStatus.OK);
    }
}
