package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.*;
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
    public ResponseEntity followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UnhandledException, BadRequestException {
        userService.addFollowUser(userId, userIdToFollow);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> findFollowersCount(@PathVariable int userId) throws UnhandledException, BadRequestException {
        return new ResponseEntity<>(userService.findFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> findFollowersByUserId(@PathVariable int userId, @RequestParam(required = false) String order) throws UnhandledException, BadRequestException {
        return new ResponseEntity<>(userService.findFollowersByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> findFollowedByUserId(@PathVariable int userId, @RequestParam(required = false) String order) throws UnhandledException, BadRequestException {
        return new ResponseEntity<>(userService.findFollowedByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UnhandledException, BadRequestException {
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
