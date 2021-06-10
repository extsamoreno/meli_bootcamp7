package com.socialMeli.controllers;

import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.FollowListDTO;
import com.socialMeli.models.DTOs.FollowersCountDTO;
import com.socialMeli.models.DTOs.UserDTO;
import com.socialMeli.models.Seller;
import com.socialMeli.services.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users/{userId}")
public class UserController {

    @Autowired
    iUserService userService;

    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow (@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        return (new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK));
    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowersCountDTO> countFollowers (@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK));
    }

    @GetMapping("/followers/list")
    public ResponseEntity<FollowListDTO> listFollowers (@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(userService.listFollowers(userId), HttpStatus.OK));
    }

    @GetMapping("/followed/list")
    public ResponseEntity<FollowListDTO> listFollowed (@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(userService.listFollowed(userId), HttpStatus.OK));
    }

    @PostMapping("/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow (@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserNotFoundException {
        return (new ResponseEntity<>(userService.unfollow(userId, userIdToUnfollow), HttpStatus.OK));
    }

    @GetMapping("/followers")
    public ResponseEntity<ArrayList<UserDTO>> orderFollowersByName(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "") String order) throws UserNotFoundException, WrongCriteriaOrderException {
        return (new ResponseEntity<>(userService.orderFollowersByName(userId, order), HttpStatus.OK));
    }

    @GetMapping("/followed")
    public ResponseEntity<ArrayList<Seller>> orderFollowedByName(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "") String order) throws UserNotFoundException, WrongCriteriaOrderException {
        return (new ResponseEntity<>(userService.orderFollowedByName(userId, order), HttpStatus.OK));
    }
}
