package com.socialMeli.controllers;

import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.FollowersCountDTO;
import com.socialMeli.models.DTOs.FollowListDTO;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;
import com.socialMeli.services.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}")
public class UserController {

    @Autowired
    iUserService service;

    @PostMapping("/follow/{userIdTofollow}")
    public ResponseEntity<Void> follow (@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        return (new ResponseEntity<>(service.follow(userId, userIdToFollow), HttpStatus.OK));
    }

    @GetMapping("/followers/count")
    public ResponseEntity<FollowersCountDTO> countFollowers (@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(service.countFollowers(userId), HttpStatus.OK));
    }

    @GetMapping("/followers/list")
    public ResponseEntity<FollowListDTO> listFollowers (@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(service.listFollowers(userId), HttpStatus.OK));
    }

    @GetMapping("/followed/list")
    public ResponseEntity<FollowListDTO> listFollowed (@PathVariable Integer userId) throws UserNotFoundException {
        return (new ResponseEntity<>(service.listFollowed(userId), HttpStatus.OK));
    }

    @PostMapping("/follow/{userIdTofollow}")
    public ResponseEntity<Void> unfollow (@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserNotFoundException {
        return (new ResponseEntity<>(service.unfollow(userId, userIdToUnfollow), HttpStatus.OK));
    }

    @GetMapping("/followers")
    public ResponseEntity<Seller> orderFollowersByName(@PathVariable Integer sellerId, @RequestParam(value = "order", defaultValue = "") String order) throws UserNotFoundException, WrongCriteriaOrderException {
        return (new ResponseEntity<>(service.orderFollowersByName(sellerId, order), HttpStatus.OK));
    }

    @GetMapping("/followed")
    public ResponseEntity<User> orderFollowedByName(@PathVariable Integer userId, @RequestParam(value = "order", defaultValue = "") String order) throws UserNotFoundException, WrongCriteriaOrderException {
        return (new ResponseEntity<>(service.orderFollowedByName(userId, order), HttpStatus.OK));
    }
}
