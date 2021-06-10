package com.desafiospring.socialMeli.controller;

import com.desafiospring.socialMeli.dto.FollowersCountDTO;
import com.desafiospring.socialMeli.dto.UserFollowedDTO;
import com.desafiospring.socialMeli.dto.UserFollowingDTO;
import com.desafiospring.socialMeli.exceptions.UserAlreadyFollowsException;
import com.desafiospring.socialMeli.exceptions.UserAlreadyUnfollowsException;
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
            throws UserNotFoundException, UserAlreadyFollowsException {
        userService.followSeller(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getNumberOfFollowers(@PathVariable int userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(userService.getNumberOfFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userID}/followers/list")
    public ResponseEntity<UserFollowedDTO> getFollowers(@PathVariable int userID,
                                                        @RequestParam(required = false) String order)
            throws UserNotFoundException {
        return new ResponseEntity<>(userService.getFollowers(userID, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowingDTO> getUserFollowed(@PathVariable Integer userId,
                                                            @RequestParam(required = false) String order)
            throws UserNotFoundException {
        return new ResponseEntity<>(userService.getFollowingList(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow)
            throws UserNotFoundException, UserAlreadyUnfollowsException {
        userService.unfollowSeller(userId, userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }

}
