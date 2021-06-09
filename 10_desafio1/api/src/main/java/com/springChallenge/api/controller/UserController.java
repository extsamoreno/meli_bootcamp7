package com.springChallenge.api.controller;

import com.springChallenge.api.controller.dto.user.FollowedListDTO;
import com.springChallenge.api.controller.dto.user.FollowerCountDTO;
import com.springChallenge.api.controller.dto.user.FollowerListDTO;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.controller.exception.user.UserValidationsException;
import com.springChallenge.api.service.contract.IUserService;
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
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserValidationsException {
        iUserService.follow(userId, userIdToFollow);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getFollowerCount(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowerCount(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> getFollowerList(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowerList(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedList(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowedList(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserValidationsException {
        iUserService.unfollow(userId, userIdToUnfollow);
    }
}
