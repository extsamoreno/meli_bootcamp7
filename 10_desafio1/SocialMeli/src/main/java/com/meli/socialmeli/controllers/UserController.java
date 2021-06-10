package com.meli.socialmeli.controllers;

import com.meli.socialmeli.services.UserService;
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
    UserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> addNewFollower(@PathVariable int userId, @PathVariable int userIdToFollow) {
        userService.addNewFollower(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
