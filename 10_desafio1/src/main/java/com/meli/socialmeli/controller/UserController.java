package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.FollowersCountUserDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.FollowerAlreadyAddedException;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.NoFollowerException;
import com.meli.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow) throws InvalidIdException, FollowerAlreadyAddedException {

        userService.addFollower(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> removeFollower(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws InvalidIdException, NoFollowerException {

        userService.removeFollower(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountUserDTO> getFollowersCount(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getFollowersList(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(userService.getFollowersList(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getFollowedList(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(userService.getFollowedList(userId), HttpStatus.OK);
    }

}

