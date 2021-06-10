package com.example.desafio_1.controller;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.service.IUserService;
import com.example.desafio_1.service.dto.FollowedListDTO;
import com.example.desafio_1.service.dto.FollowerCountDTO;
import com.example.desafio_1.service.dto.FollowerListDTO;
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

    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<Void> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnFollow) throws UserExceptionWrongType, UserExceptionNotFound, UserExceptionNotFollowing {
        userService.unfollowUser(userId, userIdToUnFollow);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> followersCount(@PathVariable int userId) throws UserExceptionNotFound, UserExceptionWrongType {
        return new ResponseEntity<FollowerCountDTO>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> followersList(@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws UserExceptionNotFound, UserExceptionWrongType, WrongOrderFieldException {
        return new ResponseEntity<FollowerListDTO>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> followingList(@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws UserExceptionNotFound, UserExceptionWrongType, WrongOrderFieldException {
        return new ResponseEntity<FollowedListDTO>(userService.getFollowingList(userId, order), HttpStatus.OK);
    }
}
