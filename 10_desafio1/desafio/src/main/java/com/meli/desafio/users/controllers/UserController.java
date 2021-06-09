package com.meli.desafio.users.controllers;

import com.meli.desafio.users.exceptions.UserAlredyFollowedException;
import com.meli.desafio.users.exceptions.UserFollowYourselfException;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.users.models.dto.ResponseUserListFollowed;
import com.meli.desafio.users.models.dto.ResponseUserListFollowers;
import com.meli.desafio.users.services.IUserService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    //user follow user2
    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> addNewFollow(
            @PathVariable Integer userId,
            @PathVariable Integer userIdToFollow
    ) throws UserNotFoundException, UserFollowYourselfException, UserAlredyFollowedException {
        userService.addNewFollow(userId, userIdToFollow);
        return new ResponseEntity<>(URLBuilder.buildURL("users", userId, "followed/list"), HttpStatus.OK);
    }

    //followers count of user
    @GetMapping(value = {"/{userId}/followers/count"})
    public ResponseEntity<ResponseUserCountFollowers> showCountFollowers(
            @PathVariable Integer userId
    ) throws UserNotFoundException {
        return new ResponseEntity<>(userService.showCountFollowers(userId), HttpStatus.OK);
    }


    //Followers list of user
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseUserListFollowers> showAllFollowers(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "name_asc") String order
    ) throws UserNotFoundException {
        return new ResponseEntity<>(userService.showAllFollowers(userId, order), HttpStatus.OK);
    }

    //followed list of user
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseUserListFollowed> showAllFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "name_asc") String order
    ) throws UserNotFoundException {
        return new ResponseEntity<>(userService.showAllFollowed(userId, order), HttpStatus.OK);
    }

    //user unfollow user2
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> removeFollow(
            @PathVariable Integer userId,
            @PathVariable Integer userIdToUnfollow
    ) throws UserNotFoundException {
        userService.removeFollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(URLBuilder.buildURL("users", userId, "followed/list"), HttpStatus.OK);
    }
}
