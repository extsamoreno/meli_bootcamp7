package com.example.demo.socialmeli.controller;

import com.example.demo.socialmeli.exception.FollowedExistingException;
import com.example.demo.socialmeli.exception.FollowedNotExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
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
public class UserController {
    @Autowired
    IUserService iUserService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> setFollowed (@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, FollowedExistingException
    {
        iUserService.follow(userId,userIdToFollow);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDTO>  numberOfFollowers (@PathVariable int userId) throws UserNotFoundException{
        return new ResponseEntity<CountFollowersDTO>( iUserService.countFollowers(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException{
        return new ResponseEntity<FollowersListDTO>( iUserService.getFollowerList(userId, order),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> followedList (@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException{
        return new ResponseEntity<FollowedListDTO>( iUserService.getFollowedList(userId, order),HttpStatus.OK);
    }
    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity<Void> setUnFollowed (@PathVariable int userId, @PathVariable int userIdToUnFollow) throws UserNotFoundException, FollowedNotExistingException {
        iUserService.unFollow(userId,userIdToUnFollow);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
