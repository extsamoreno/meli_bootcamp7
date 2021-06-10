package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.user.FollowersCountDTO;
import com.meli.socialmeli.dto.user.UserFollowersDTO;
import com.meli.socialmeli.dto.user.UserFollowedDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    //Requirement US 0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserIdNotFoundException {
        iUserService.followUser(userId,userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Requirement US 0002
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> getUserFollowersCount(@PathVariable Integer userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    //Requirement US 0003/008
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getUserFollowers(@PathVariable Integer userId, @RequestParam(required = false) String order) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getUserFollowers(userId,order), HttpStatus.OK);
    }

    //Requirement US 0004/008
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getUserFollowed(@PathVariable Integer userId, @RequestParam(required = false) String order) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getUserFollowed(userId,order), HttpStatus.OK);
    }

    //Requirement US 0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserIdNotFoundException {
        iUserService.unfollowUser(userId,userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
