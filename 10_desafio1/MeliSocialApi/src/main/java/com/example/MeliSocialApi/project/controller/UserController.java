package com.example.MeliSocialApi.project.controller;

import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.exception.UsersMustBeDifferentException;
import com.example.MeliSocialApi.project.service.IUserService;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity addFollower(@PathVariable Integer userId,@PathVariable Integer userIdToFollow) throws UserNotFoundException, UsersMustBeDifferentException {
        userService.follow(userId,userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTOResponse> getFollowersCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<UserFollowersCountDTOResponse>(userService.getFollowersCount(userId),HttpStatus.OK);
    }
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollow(@PathVariable Integer userId,@PathVariable Integer userIdToUnfollow) throws UserNotFoundException, UsersMustBeDifferentException {
        userService.unfollow(userId,userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersUserDTOResponse> getFollowers(@PathVariable Integer userId, @RequestParam Optional<String> order) throws UserNotFoundException {
        return new ResponseEntity<FollowersUserDTOResponse>(userService.getFollowersList(userId,order),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowersUserDTOResponse> getFollowed(@PathVariable Integer userId,@RequestParam Optional<String> order) throws UserNotFoundException {
        return new ResponseEntity<FollowersUserDTOResponse>(userService.getFollowedList(userId,order),HttpStatus.OK);
    }
}
