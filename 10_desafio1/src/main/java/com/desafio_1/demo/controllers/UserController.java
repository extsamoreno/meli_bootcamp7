package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.exceptions.UserIdFollowerEqualsFollowed;
import com.desafio_1.demo.exceptions.UserIdInvalidException;
import com.desafio_1.demo.exceptions.UserNotFoundException;
import com.desafio_1.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed, UserNotFoundException {
        userService.addFollowUser(userId, userIdToFollow);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> findFollowersCount(@PathVariable int userId) throws UserIdInvalidException, UserNotFoundException, UnhandledException {
        return new ResponseEntity<>(userService.findFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> findFollowersByUserId(@PathVariable int userId, @RequestParam(required = false) String order) throws UserIdInvalidException, UserNotFoundException, UnhandledException {
        return new ResponseEntity<>(userService.findFollowersByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> findFollowedByUserId(@PathVariable int userId, @RequestParam(required = false) String order) throws UserIdInvalidException, UserNotFoundException, UnhandledException {
        return new ResponseEntity<>(userService.findFollowedByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed {
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
