package com.example.Challenge.controller;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.service.IUserService;
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
    public ResponseEntity<String> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        iUserService.Follow(userId, userIdToFollow);
        return  new ResponseEntity<>("OK", HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserResponseCountDTO> userFollowersCount(@PathVariable Integer userId){
        UserResponseCountDTO resultUser= iUserService.getUserFollowersCount(userId);
        return  new ResponseEntity<>(resultUser, HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserResponseListDTO> userFollowersList(@PathVariable Integer userId){
        UserResponseListDTO resultListUser= iUserService.getUserFollowersList(userId);
        return  new ResponseEntity<>(resultListUser, HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserResponseListFollowedDTO> userFollowedList(@PathVariable Integer userId){
        UserResponseListFollowedDTO resultListFollowedUser= iUserService.getUserFollowedList(userId);
        return  new ResponseEntity<>(resultListFollowedUser, HttpStatus.OK);
    }


}
