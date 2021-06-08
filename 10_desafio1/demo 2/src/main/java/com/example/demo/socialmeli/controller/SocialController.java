package com.example.demo.socialmeli.controller;

import com.example.demo.socialmeli.service.IUserService;
import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowedListDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class SocialController {
    @Autowired
    IUserService iUserService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public HttpStatus setFollowed (@PathVariable int userId, @PathVariable int userIdToFollow) {
        return iUserService.follow(userId,userIdToFollow);
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDTO>  numberOfFollowers (@PathVariable int userId) {
        return new ResponseEntity<CountFollowersDTO>( iUserService.countFollowers(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable int userId) {
        return new ResponseEntity<FollowersListDTO>( iUserService.getFollowerList(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> followedList (@PathVariable int userId) {
        return new ResponseEntity<FollowedListDTO>( iUserService.getFollowedList(userId),HttpStatus.OK);
    }
}
