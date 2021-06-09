package com.example.desafio1.controllers;

import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    // Create database of users
    @PostMapping("/create")
    public ResponseEntity<String> followSeller() {
        return new ResponseEntity(iUserService.createDB(), HttpStatus.OK);
    }

    // An user follow a user
    // Parameters
    // @userId,  number that identifies the actual user
    // @userIdToFollow,  number that identifies the user to follow
    // Response 200 / 400 -> if any of the users does not exists
    // Example: /users/5/follow/1
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId,
                                               @PathVariable int userIdToFollow) throws InvalidUserIdException {
        return new ResponseEntity(iUserService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    // An user UNfollow a user
    // Parameters
    // @userId,  number that identifies the actual user
    // @userIdToUnfollow,  number that identifies the user to unfollow
    // Response 200 / 400 -> if any of the users does not exists
    // Example: /users/2/unfollow/1
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId,
                                             @PathVariable int userIdToUnfollow) throws InvalidUserIdException {
        return new ResponseEntity(iUserService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    // Get the number of followers that user has
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example: /users/1/followers/count/
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<ResponseFollowerCountDTO> getFollowerCount(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    // Get the followers of the user
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example: /users/1/followers/list
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseFollowerListDTO> getFollowers(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity(iUserService.getFollowers(userId), HttpStatus.OK);
    }

    // Get the sellers that the user follows
    // Parameters
    // @userId,  number that identifies the actual user
    // Response 200 / 400 -> if the user does not exists
    // Example: /users/1/followed/list
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseFollowerListDTO> getFollowedSellers(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity(iUserService.getFollowedSellers(userId), HttpStatus.OK);
    }
}
