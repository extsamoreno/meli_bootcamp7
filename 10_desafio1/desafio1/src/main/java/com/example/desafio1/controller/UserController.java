package com.example.desafio1.controller;

import com.example.desafio1.exception.user.UserAlreadyFollowException;
import com.example.desafio1.exception.user.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.user.UserNotFollowException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.service.dto.user.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowersDTO;
import com.example.desafio1.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    iUserService iUserService;

    // A user follow other user
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException {
        iUserService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Number of followers of a user
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<ResponseCountFollowersDTO> countFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.countFollowers(userId), HttpStatus.OK);
    }

    // User followers list
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseListFollowersDTO> listFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.listFollowers(userId), HttpStatus.OK);
    }

    // User followed list
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseListFollowedDTO> listFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.listFollowed(userId), HttpStatus.OK);
    }

    // Unfollow a user
    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<Void> unFollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnFollow) throws UserNotFoundException, UserNotFollowException {
        iUserService.unFollowUser(userId, userIdToUnFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
