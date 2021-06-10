package com.springChallenge.api.controller;

import com.springChallenge.api.controller.dto.user.FollowedListDTO;
import com.springChallenge.api.controller.dto.user.FollowerCountDTO;
import com.springChallenge.api.controller.dto.user.FollowerListDTO;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.controller.exception.user.UserValidationsException;
import com.springChallenge.api.service.contract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    /**
     * Endpoint to add a follower to an user and a sellerFollowed to another user
     * @param userId the user that starts the follow
     * @param userIdToFollow the user is going to be followed
     * @throws UserValidationsException if user doesn't exist, or params are the same or is already followed
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserValidationsException {
        iUserService.follow(userId, userIdToFollow);
    }

    /**
     * Returns a {@link FollowerCountDTO} for a given user
     * @param userId the id of the user
     * @return a {@link FollowerCountDTO}
     * @throws UserNotFoundException if user doesn't exist
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getFollowerCount(@PathVariable Integer userId) throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowerCount(userId), HttpStatus.OK);
    }

    /**
     * Returns a {@link FollowerListDTO} for a given user
     * @param userId the id of the user
     * @param order Optional, name_asc or name_desc for ordering by userName
     * @return a {@link FollowerListDTO}
     * @throws UserNotFoundException if user doesn't exist
     */
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> getFollowerList
            (@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "") String order)
            throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowerList(userId, order), HttpStatus.OK);
    }

    /**
     * Returns a {@link FollowedListDTO} for a given user
     * @param userId the id of the user
     * @param order Optional, name_asc or name_desc for ordering by userName
     * @return a {@link FollowedListDTO}
     * @throws UserNotFoundException
     */
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedList
            (@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "") String order)
            throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowedList(userId, order), HttpStatus.OK);
    }

    /**
     * Endpoint to remove a follower to an user and sellerFollowed to another user
     * @param userId the user that is already follows the other user
     * @param userIdToUnfollow the user to be unfollowed
     * @throws UserValidationsException if user doesn't exist, or params are the same or is not being followed
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserValidationsException {
        iUserService.unfollow(userId, userIdToUnfollow);
    }
}
