package com.example.desafio1.controller;

import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.User;
import com.example.desafio1.service.user.IUserService;
import com.example.desafio1.service.dto.userdto.FollowedListDTO;
import com.example.desafio1.service.dto.userdto.FollowersCountDTO;
import com.example.desafio1.service.dto.userdto.FollowersListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users/")
public class UsersController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/lsUsers")
    public ResponseEntity<ArrayList<User>> getUsersList()
    {
        return new ResponseEntity<>(iUserService.getUsersList(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId, @PathVariable int userIdToFollow)
            throws UserNotFoundException
    {
        return new ResponseEntity<>(iUserService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow)
            throws UserNotFoundException
    {
        return new ResponseEntity<>(iUserService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId)
            throws UserNotFoundException
    {
        return new ResponseEntity<>(iUserService.getFollowersCountDTO(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersList(@PathVariable int userId,
                                                             @RequestParam(required=false,
                                                                     defaultValue = "name_asc")
                                                                     String order)
            throws UserNotFoundException
    {
        return new ResponseEntity<>(iUserService.getFollowersListDTO(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedList(@PathVariable int userId,
                                                           @RequestParam(required=false,
                                                                   defaultValue = "name_asc")
                                                                   String order)
            throws UserNotFoundException
    {
        return new ResponseEntity<>(iUserService.getFollowedListDTO(userId, order), HttpStatus.OK);
    }

}