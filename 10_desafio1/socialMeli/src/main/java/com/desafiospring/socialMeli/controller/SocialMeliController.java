package com.desafiospring.socialMeli.controller;

import com.desafiospring.socialMeli.dto.FollowersCountDTO;
import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.dto.UserFollowedDTO;
import com.desafiospring.socialMeli.dto.UserFollowingDTO;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.service.SocialMeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    @Autowired
    SocialMeliService socialMeliService;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow)
            throws UserNotFoundException {
        socialMeliService.followSeller(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> numberOfFollowers(@PathVariable int userId)
            throws UserNotFoundException{
        return new ResponseEntity<>(socialMeliService.getNumberOfFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("/users/{userID}/followed/list")
    public ResponseEntity<UserFollowingDTO> followingList(@PathVariable int userID)
            throws UserNotFoundException{
        return new ResponseEntity<>(socialMeliService.getFollowingList(userID), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getUserFollowed(@PathVariable Integer userId)
            throws UserNotFoundException {
        return new ResponseEntity<>(socialMeliService.getFollowers(userId),HttpStatus.OK);
    }
}
