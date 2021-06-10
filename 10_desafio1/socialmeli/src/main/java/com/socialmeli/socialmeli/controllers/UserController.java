package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.exceptions.UserAlreadyFollowedException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.exceptions.UserSameIdException;
import com.socialmeli.socialmeli.services.UserService;
import com.socialmeli.socialmeli.services.dtos.UserCountDTO;
import com.socialmeli.socialmeli.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId , @PathVariable Integer userIdToFollow) throws UserNotFoundException, UserSameIdException, UserAlreadyFollowedException {
        userService.followUser(userId,userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity unFollowUser(@PathVariable Integer userId , @PathVariable Integer userIdToUnFollow) throws UserNotFoundException {
        userService.unFollowUser(userId,userIdToUnFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountDTO> getUserFollowersCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getUserFollowers(@PathVariable Integer userId,@RequestParam Optional<String> order) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowers(userId,order),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getUserFollowed(@PathVariable Integer userId,@RequestParam Optional<String> order) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowed(userId,order),HttpStatus.OK);
    }



}
