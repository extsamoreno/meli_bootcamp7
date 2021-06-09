package com.meli.socialmeli.controller.user;

import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;
import com.meli.socialmeli.exception.FollowException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws IdNotFoundException, FollowException {
        userService.followUser(userId, userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{userId}/followers/count/")
    public UserWithFollowersCountDTO followersCount(@PathVariable Integer userId) throws IdNotFoundException {
        return userService.followersCountOf(userId);
    }

    @GetMapping("/{userId}/followers/list")
    public UserWithFollowersDTO followersListOf(@PathVariable Integer userId) throws IdNotFoundException {
        return userService.followersOf(userId);
    }

    @GetMapping("/{userId}/followed/list")
    public UserWithFollowedDTO followedListOf(@PathVariable Integer userId) throws IdNotFoundException {
        return userService.followedOf(userId);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws IdNotFoundException, FollowException {
        userService.unfollowUser(userId, userIdToUnfollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
