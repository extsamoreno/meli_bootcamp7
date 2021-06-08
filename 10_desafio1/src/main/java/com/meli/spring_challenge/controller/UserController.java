package com.meli.spring_challenge.controller;

import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.model.User;
import com.meli.spring_challenge.service.dto.FollowersCountDto;
import com.meli.spring_challenge.service.dto.FollowDto;
import com.meli.spring_challenge.service.follow.FollowService;
import com.meli.spring_challenge.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    FollowService followService;


    //US 0001
    @PostMapping("/{userID}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable int userID, @PathVariable int userIdToFollow){
        followService.followUser(userID, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    //US 0002
    @GetMapping("/{userID}/followers/count/")
    public ResponseEntity<FollowersCountDto> getFollowCountByUserID(@PathVariable int userID){
        FollowersCountDto result = followService.getFollowCountByUserID(userID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //US 0003
    @GetMapping("/{userID}/followers/list")
    public ResponseEntity<FollowDto> getFollowersByUserID(@PathVariable int userID){
        FollowDto result = followService.getFollowersByUserID(userID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    //US 0004
    @GetMapping("/{userID}/followed/list")
    public ResponseEntity<FollowDto> getFollowedByUserID(@PathVariable int userID){
        FollowDto result = followService.getFollowedByUserID(userID);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }



    //Get all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> result = userService.getAllUsers();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    //Get all follows
    @GetMapping("/all/followers")
    public ResponseEntity<List<Follow>> getAllFollows(){
        List<Follow> result = followService.getAllFollows();
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
