package com.challenge.controller;

import com.challenge.exception.UserIdNotFoundException;
import com.challenge.service.UserService;
import org.apache.coyote.Response;
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
    public ResponseEntity follow(@PathVariable Integer userId, @PathVariable Integer userToFollow) throws IOException, UserIdNotFoundException {
        userService.follow(userId, userToFollow);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserIdNotFoundException {
        userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity getFollowersCount(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(userService.getFollowersCount(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity getFollowers(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(userService.getFollowers(userId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity getFollows(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(userService.getFollows(userId));
    }
}
