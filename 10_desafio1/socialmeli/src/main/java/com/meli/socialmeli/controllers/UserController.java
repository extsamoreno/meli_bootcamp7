package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.*;
import com.meli.socialmeli.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    //Punto 1 LISTO
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserFollowDTO> followMerchant(@PathVariable int userId,
                                                        @PathVariable int userIdToFollow) throws UserInvalidException, UserIsNotMerchant, UserItselfException, UserDoNotExistsException {
        return new ResponseEntity<>(iUserService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    //Punto 2 Listo
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<UserFollowerCount> followersCount(@PathVariable int userId) {
        return new ResponseEntity<>(iUserService.getFollowerCount(userId), HttpStatus.ACCEPTED);
    }

    //Punto 3 Listo
    @GetMapping("/{userId}/followers/list") //?order=name_asc
    public ResponseEntity<UserFollowerListDTO> followersList(@PathVariable int userId,
                                                             @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(iUserService.getFollowerList(userId, order), HttpStatus.OK);
    }

    // Punto 4 Listo
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<UserFollowedByListDTO> getFollowedByList(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(iUserService.getFollowedBy(userId, order), HttpStatus.OK);
    }

    //Punto 7 LISTO
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UserFollowDTO> UnfollowMerchant(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserInvalidException, UserNotFoundException {
        return new ResponseEntity<>(iUserService.unfollow(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
