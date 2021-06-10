package com.socialmedia.socialmedia.controllers;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.services.IUserService;
import com.socialmedia.socialmedia.services.dtos.UserCountFollowerDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followToUser(@PathVariable int userId, @PathVariable int userIdToFollow)
            throws UserNotFoundException, UserExistAsFollowerException, UserDistinctTypeException, ObjectNotFoundException {

        userService.followToUser(userId, userIdToFollow);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<Void> unfollowToUser(@PathVariable int userId, @PathVariable int userIdToFollow)
            throws ObjectNotFoundException, UserNotFoundException, UserNotExistAsFollowerException {

        userService.unfollowToUser(userId, userIdToFollow);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountFollowerDTO> getCountFollowersByUser(@PathVariable int userId) throws ObjectNotFoundException, UserDistinctTypeException {

        UserCountFollowerDTO userCountFollowerDTO = userService.getCountFollowersByUser(userId);

        return new ResponseEntity<>(userCountFollowerDTO, HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followers/list")
    public ResponseEntity<UserWithFollowersDTO> getFollowersByUser(@PathVariable("UserID") int userId) throws ObjectNotFoundException, UserDistinctTypeException {

        UserWithFollowersDTO userWithFollowersDTO = userService.getFollowersByUser(userId);

        return new ResponseEntity<>(userWithFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followed/list")
    public ResponseEntity<UserWithFollowedDTO> getFollowedByUser(@PathVariable("UserID") int userId) throws ObjectNotFoundException, UserDistinctTypeException {

        UserWithFollowedDTO userWithFollowedDTO = userService.getFollowedByUser(userId);

        return new ResponseEntity<>(userWithFollowedDTO, HttpStatus.OK);
    }
}
