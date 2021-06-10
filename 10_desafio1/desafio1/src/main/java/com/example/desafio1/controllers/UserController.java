package com.example.desafio1.controllers;

import com.example.desafio1.dtos.FollowedDTO;
import com.example.desafio1.dtos.FollowersCountDTO;
import com.example.desafio1.dtos.FollowersDTO;
import com.example.desafio1.exceptions.*;
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

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    @ResponseStatus(HttpStatus.OK)
    public String postFollow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserIdNotValidException, FollowingAlreadyExistsException, RepeatedUsersIdException {
        iUserService.processNewFollowing(userId,userIdToFollow);
        return "Following has been set up successfully!";
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId) throws OrderNotValidException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers(@PathVariable int userId,@RequestParam(required = false) String order) throws OrderNotValidException {
        return new ResponseEntity<>(iUserService.getFollowers(userId,order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(@PathVariable int userId,@RequestParam(required = false) String order) throws OrderNotValidException {
        return new ResponseEntity<>(iUserService.getFollowed(userId,order), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    @ResponseStatus(HttpStatus.OK)
    public String postUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserIdNotValidException, FollowingDoesNotExistException {
        iUserService.processUnfollow(userId,userIdToUnfollow);
        return "User unfollowed successfully!";
    }
}
