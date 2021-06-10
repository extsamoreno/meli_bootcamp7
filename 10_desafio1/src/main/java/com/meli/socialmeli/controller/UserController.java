package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.FollowersCountUserDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.FollowerAlreadyAddedException;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.NoFollowerException;
import com.meli.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Inserts a new follower. This performs two actions:
     * 1) In the user who will be a follower, a new followed user is inserted
     * 2) In the user that is followed, a new follower is inserted
     *
     * @param userId         Corresponding to the user who will follow another
     * @param userIdToFollow Corresponding to the user to be followed
     * @throws InvalidIdException            If either or both of the IDs entered do not correspond to an existing user
     * @throws FollowerAlreadyAddedException If the user to be added as a follower is already a follower of the followed user
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> addFollower(@PathVariable int userId, @PathVariable int userIdToFollow) throws InvalidIdException, FollowerAlreadyAddedException {

        userService.addFollower(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Removes a follower.This performs two actions:
     * 1) In the user who will unfollow, the followed user is deleted
     * 2) In the user that will stop being followed, the follower is deleted
     *
     * @param userId           Corresponding to the user who will unfollow another
     * @param userIdToUnfollow Corresponding with the user who will be unfollowed
     * @throws InvalidIdException  If either or both of the IDs entered do not correspond to an existing user
     * @throws NoFollowerException If the user to be removed from the followers, is not a seller´s follower
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> removeFollower(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws InvalidIdException, NoFollowerException {

        userService.removeFollower(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Gets the number of followers a user has
     *
     * @param userId Corresponding to the user from which you want to obtain the followers count
     * @return The number of followers a user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountUserDTO> getFollowersCount(@PathVariable int userId) throws InvalidIdException {

        return new ResponseEntity<>(userService.getFollowersCount(userId), HttpStatus.OK);
    }

    /**
     * Get the followers that a user has.
     *
     * @param userId Corresponding to the user from which you want to obtain the followers
     * @param order  The alphabetical order in which you want to obtain the results. This order can be ascending or descending
     * @return The user who has been searched, with the followers that this user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getFollowersList(@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws InvalidIdException {

        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    /**
     * Gets the sellers that the entered user follows
     *
     * @param userId Corresponding to the user from whom you want to obtain the followed sellers
     * @param order  The alphabetical order in which you want to obtain the results. This order can be ascending or descending
     * @return The user who has been searched, with the sellers that the user follows
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getFollowedList(@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws InvalidIdException {

        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

}

