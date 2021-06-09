package com.challenge.controller;

import com.challenge.dto.FollowersCountResponse;
import com.challenge.dto.FollowersResponse;
import com.challenge.dto.UserDTO;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/follow/{userToFollow}")
    public ResponseEntity<String> follow(@PathVariable Integer userId, @PathVariable Integer userToFollow) throws IOException, UserIdNotFoundException {
        userService.follow(userId, userToFollow);
        return ResponseEntity.ok("User followed");
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserIdNotFoundException {
        userService.unfollow(userId, userIdToUnfollow);
        return ResponseEntity.ok("User unfollowed");
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountResponse> getFollowersCount(@PathVariable Integer userId) throws UserIdNotFoundException {
        return ResponseEntity.ok(userService.getFollowersCount(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersResponse> getFollowers(@PathVariable Integer userId, @RequestParam(name = "order", required = false) SortingUserEnum sorting) throws UserIdNotFoundException {
        return ResponseEntity.ok(userService.getFollowers(userId, sorting));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowersResponse> getFollows(@PathVariable Integer userId, @RequestParam(name = "order", required = false) SortingUserEnum sorting) throws UserIdNotFoundException {
        return ResponseEntity.ok(userService.getFollows(userId, sorting));
    }
}
