package com.example.challenge.Controllers;

import com.example.challenge.Exceptions.*;
import com.example.challenge.Services.DTOs.FollowDTO;
import com.example.challenge.Services.DTOs.FollowerCountDTO;
import com.example.challenge.Services.DTOs.FollowersDTO;
import com.example.challenge.Services.DTOs.GetUserDTO;
import com.example.challenge.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    //Load HardCode Data
    @PostMapping("/load")
    public ResponseEntity<String> create() throws UserNotFoundException, PostDuplicateException {
        return new ResponseEntity<>(iUserService.loadUser(), HttpStatus.OK);
    }

    // Get a list with all the users (usefull to check changes)
    @GetMapping
    public ResponseEntity<List<GetUserDTO>> getUsers() {

        return new ResponseEntity<>(iUserService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/create/{userName}")
    public ResponseEntity<String> create(@PathVariable String userName) throws Exception {

        return new ResponseEntity<>(iUserService.addUser(userName), HttpStatus.OK);
    }

    @PostMapping("/{followerId}/follow/{followedID}")
    public ResponseEntity<FollowDTO> follow(@PathVariable int followerId, @PathVariable int followedID) throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException {

        return new ResponseEntity<>(iUserService.followUser(followerId, followedID), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<FollowDTO> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException {

        return new ResponseEntity<>(iUserService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getFollowersCount(@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers(@PathVariable int userId, @RequestParam(required = false,
            defaultValue = "") String order) throws UserNotFoundException, InvalidOrderException {

        return new ResponseEntity<>(iUserService.getFollowers(userId, order), HttpStatus.OK);

    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowersDTO> getFollowed(@PathVariable int userId ,@RequestParam(required = false,
            defaultValue = "") String order) throws UserNotFoundException, InvalidOrderException {

        return new ResponseEntity<>(iUserService.getFollowed(userId, order), HttpStatus.OK);

    }



}