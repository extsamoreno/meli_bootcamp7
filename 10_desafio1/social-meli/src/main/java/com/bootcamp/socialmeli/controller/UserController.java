package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.response.UserAmountFollowersDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowedListDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowersListDTOres;
import com.bootcamp.socialmeli.exception.FollowYourselfException;
import com.bootcamp.socialmeli.exception.UnfollowYourselfException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow)
            throws UserIdNotFoundException, FollowYourselfException {

        userService.follow(userId, userIdToFollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserAmountFollowersDTOres> getAmountUserFollowers(@PathVariable Integer userId)
            throws UserIdNotFoundException {
        return new ResponseEntity<>(userService.getAmountUserFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTOres> getListUserFollowers(
            @PathVariable Integer userId, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        return new ResponseEntity<>(userService.getListUserFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDTOres> getListUserFollowed(
            @PathVariable Integer userId, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        return new ResponseEntity<>(userService.getListUserFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(
            @PathVariable Integer userId, @PathVariable Integer userIdToUnfollow)
            throws UserIdNotFoundException, UnfollowYourselfException {
        userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
