package com.spring.desafioSpring.Controllers;

import com.spring.desafioSpring.DTOs.CountUserFollowersDTO;
import com.spring.desafioSpring.DTOs.FollowedUserDTO;
import com.spring.desafioSpring.DTOs.FollowersUserDTO;
import com.spring.desafioSpring.Exceptions.FollowYourselfException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    //US0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity follow(@PathVariable() int userId, @PathVariable() int userIdToFollow)
            throws UserNotFoundException, FollowYourselfException {

        iUserService.follow(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

    //US0002
    @GetMapping("{userId}/followers/count")
    public ResponseEntity<CountUserFollowersDTO> followersCount(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.countFollowers(userId), HttpStatus.OK);
    }

    //US0003 - US0008(order by name)
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<FollowersUserDTO> followersByUser(@PathVariable int userId, @RequestParam(required = false) String order)
            throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.followersByUser(userId, order), HttpStatus.OK);
    }

    //US0004 - US0008(order by name)
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedUserDTO> followedByUser(@PathVariable int userId, @RequestParam(required = false) String order)
            throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.followedByUser(userId, order), HttpStatus.OK);
    }

    //US0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollow(@PathVariable() int userId, @PathVariable() int userIdToUnfollow)
            throws UserNotFoundException {

        iUserService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity(HttpStatus.OK);
    }







}
