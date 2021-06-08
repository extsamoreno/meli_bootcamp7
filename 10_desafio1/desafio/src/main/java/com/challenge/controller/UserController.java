package com.challenge.controller;

import com.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/followed/{userToFollow}")
    public ResponseEntity follow(@PathVariable Integer userId, @PathVariable Integer userToFollow) throws IOException {
        userService.follow(userId, userToFollow);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity getFollowersCount(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getFollowersCount(userId));
    }

}
