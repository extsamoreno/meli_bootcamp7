package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.*;
import com.example.socialmeli.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socialmeli/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addOne")
    public ResponseEntity<NewUserResponseDTO> addUser (@RequestBody NewUserRequestDTO newUser) throws ExistentUserException, InvalidUserException {
        return new ResponseEntity<>(userService.addUser(newUser), HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowSellerResponseDTO> followSeller (@PathVariable int userId, @PathVariable int userIdToFollow) throws InexistentUserException, ExistentFollowerException, InvalidFollowerException {
        return new ResponseEntity<>(userService.followSeller(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountResponseDTO> countFollowers (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ListFollowersResponseDTO> listFollowers (@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws InexistentUserException, InexistentNameOrderException {
        return new ResponseEntity<>(userService.listFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ListFollowedResponseDTO> listFollowed (@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws InexistentUserException, InexistentNameOrderException {
        return new ResponseEntity<>(userService.listFollowed(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<FollowSellerResponseDTO> unfollowSeller (@PathVariable int userId, @PathVariable int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException {
        return new ResponseEntity<>(userService.unfollowSeller(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
