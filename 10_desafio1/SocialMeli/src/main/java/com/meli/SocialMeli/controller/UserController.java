package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.UserFollowedListDto;
import com.meli.SocialMeli.dto.UserFollowerCountDto;
import com.meli.SocialMeli.dto.UserFollowerListDto;
import com.meli.SocialMeli.dto.UserNewDto;
import com.meli.SocialMeli.exception.FollowNotFoundUserException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.exception.InvalidUserNameException;
import com.meli.SocialMeli.exception.RepeatedFollowUserException;
import com.meli.SocialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping(path = "/new")
    public ResponseEntity<String> newUser(@RequestBody UserNewDto newUser) throws InvalidUserNameException {
        iUserService.newUser(newUser);
        return new ResponseEntity<String>("User created successfully", HttpStatus.CREATED);
    }

    @PostMapping(path = "/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> follow(@PathVariable("userId") int followerId, @PathVariable("userIdToFollow") int followedId) throws InvalidUserIdException, RepeatedFollowUserException {
        iUserService.follow(followerId,followedId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable("userId") int followerId, @PathVariable("userIdToUnfollow") int followedId) throws FollowNotFoundUserException {
        iUserService.unfollow(followerId,followedId);
        return new ResponseEntity<>("The seller has been unfollowed succesfully", HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDto> followerCount(@PathVariable("userId")int id) throws InvalidUserIdException {
        UserFollowerCountDto user = iUserService.followerCount(id);
        return new ResponseEntity<UserFollowerCountDto>(user,HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}/followers/list")
    public ResponseEntity<UserFollowerListDto> followerList(@PathVariable("userId")int id, @RequestParam("order") Optional<String> order) throws InvalidUserIdException {
        UserFollowerListDto user = iUserService.followerList(id,order);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(path = "/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDto> followedList(@PathVariable("userId")int id, @RequestParam("order") Optional<String> order) throws InvalidUserIdException {
        UserFollowedListDto user = iUserService.followedList(id,order);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}