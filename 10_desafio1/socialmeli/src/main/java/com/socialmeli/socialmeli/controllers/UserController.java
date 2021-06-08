package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.UserService;
import com.socialmeli.socialmeli.services.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId , @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        userService.followUser(userId,userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDTO> getUserFollowersCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowersCount(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getUserFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowers(userId),HttpStatus.OK);
    }



}
