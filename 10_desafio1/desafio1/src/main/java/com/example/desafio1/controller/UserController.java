package com.example.desafio1.controller;

import com.example.desafio1.exception.user.UserAlreadyFollowException;
import com.example.desafio1.exception.user.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.service.dto.user.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowersDTO;
import com.example.desafio1.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    iUserService iUserService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException {
        iUserService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<ResponseCountFollowersDTO> countFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseListFollowersDTO> listFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.listFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseListFollowedDTO> listFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.listFollowed(userId), HttpStatus.OK);
    }
}
