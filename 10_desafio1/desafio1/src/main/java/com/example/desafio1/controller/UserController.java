package com.example.desafio1.controller;

import com.example.desafio1.exception.UserAlreadyFollowException;
import com.example.desafio1.exception.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.service.dto.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.ResponseListFollowersDTO;
import com.example.desafio1.service.iServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    iServiceUser iServiceUser;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException {
        iServiceUser.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<ResponseCountFollowersDTO> countFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iServiceUser.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseListFollowersDTO> listFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iServiceUser.listFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseListFollowedDTO> listFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(iServiceUser.listFollowed(userId), HttpStatus.OK);
    }



}
