package com.socialMeli.user;

import com.socialMeli.user.exceptions.UserNotFoundException;
import com.socialMeli.user.models.FollowersCountDTO;
import com.socialMeli.user.models.FollowListDTO;
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

    



}
