package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserAlreadyUnfollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.service.IUserService;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> followAnUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserAlreadyFollowedException, UserNotFoundException {
        HttpStatus status=iUserService.followUser(userId,userIdToFollow);
        return new ResponseEntity<>(status, status);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserDTOFollowersCount> getFollowersCount(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserDTOFollowersList> getFollowersList(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersList(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserDTOFollowedList> getFollowedList(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowedList(userId),HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<HttpStatus> unfollowAnUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UserAlreadyUnfollowedException {
        HttpStatus status=iUserService.unfollowUser(userId,userIdToUnfollow);
        return new ResponseEntity<>(status,status);
    }
}
