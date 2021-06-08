package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.UserDTO;
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
    public ResponseEntity<UserDTO> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed {
        return new ResponseEntity<>(userService.addFollowUser(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDTO> findFollowersCount(@PathVariable Integer userId) throws UserIdInvalidException, UserNotFoundException, UnhandledException {
        return new ResponseEntity<>(userService.findFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<UserFollowerDTO> findFollowersByUserId(@PathVariable Integer userId) throws UserIdInvalidException, UserNotFoundException, UnhandledException {
        return new ResponseEntity<>(userService.findFollowersByUserId(userId), HttpStatus.OK);
    }


}
