package com.desafiospring.socialMeli.controller;

import com.desafiospring.socialMeli.dto.FollowersCountDTO;
import com.desafiospring.socialMeli.dto.UserFollowedDTO;
import com.desafiospring.socialMeli.dto.UserFollowingDTO;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.service.IUserService;
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
    public ResponseEntity followUser(@PathVariable int userId, @PathVariable int userIdToFollow)
            throws UserNotFoundException {
        userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> numberOfFollowers(@PathVariable int userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(userService.getNumberOfFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userID}/followers/list")
    public ResponseEntity<UserFollowedDTO> followingList(@PathVariable int userID)
            throws UserNotFoundException {
        return new ResponseEntity<>(userService.getFollowers(userID), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowingDTO> getUserFollowed(@PathVariable Integer userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(userService.getFollowingList(userId), HttpStatus.OK);
    }

}
