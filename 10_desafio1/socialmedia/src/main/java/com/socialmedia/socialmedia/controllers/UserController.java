package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.exceptions.UserExistAsFollowerException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followToUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, UserExistAsFollowerException {

        userService.followToUser(userId, userIdToFollow);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
