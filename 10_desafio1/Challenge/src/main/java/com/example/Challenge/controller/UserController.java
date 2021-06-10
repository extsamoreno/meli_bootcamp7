package com.example.Challenge.controller;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.exception.ProgramException;
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
    public ResponseEntity<String> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws ProgramException {
        iUserService.Follow(userId, userIdToFollow);
        return  new ResponseEntity<>("OK", HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserResponseCountDTO> userFollowersCount(@PathVariable Integer userId) throws ProgramException {
        UserResponseCountDTO resultUser= iUserService.getUserFollowersCount(userId);
        return  new ResponseEntity<>(resultUser, HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserResponseListDTO> userFollowersList(@PathVariable Integer userId, @RequestParam(required = false) String order) throws ProgramException {
        UserResponseListDTO resultListUser= iUserService.getUserFollowersList(userId, order);
        return  new ResponseEntity<>(resultListUser, HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserResponseListFollowedDTO> userFollowedList(@PathVariable Integer userId, @RequestParam(required = false) String order) throws ProgramException {
        UserResponseListFollowedDTO resultListFollowedUser= iUserService.getUserFollowedList(userId, order);
        return  new ResponseEntity<>(resultListFollowedUser, HttpStatus.OK);
    }
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws ProgramException {
        iUserService.Unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }




}
