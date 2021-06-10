package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.IncorrectOrderTypeException;
import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserAlreadyUnfollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.service.IUserService;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    IUserService iUserService;

    /**
     * This is the US 0001 Endpoint, which enable the option to do a "follow"
     * to an specific user
     * @param userId -> the id of the user who will follow the other user
     * @param userIdToFollow -> is the id of the user to be followed
     * @return -> status OK if all is correct, BAD_REQUEST if not
     * @throws UserAlreadyFollowedException -> If the user already followed the other user
     * @throws UserNotFoundException -> If the user hasn't been found
     */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> followAnUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserAlreadyFollowedException, UserNotFoundException {
        HttpStatus status=iUserService.followUser(userId,userIdToFollow);
        return new ResponseEntity<>(status, status);
    }

    /**
     * This is the US 0002 Endpoint, which enable the option to get the followers
     * count of an specific seller
     * @param userId -> the id of the seller
     * @return -> the seller id(as userId), seller name(as userName) and the followers count
     * @throws UserNotFoundException -> If the user hasn't been found
     */
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<UserDTOFollowersCount> getFollowersCount(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    /**
     * This is the US 0003/0008 Endpoint, which enable the option to get a list of
     * all users who follow a certain seller (Who's following me?)
     * @param userId -> the id of the user who is asked who is following him
     * @param order -> Optional parameter which allows the user to choose a sort order
     * @return -> the user id, the user name and the list of his followers
     * @throws UserNotFoundException -> If the user hasn't been found
     * @throws IncorrectOrderTypeException -> If the order parameter is defined with
     * an unknown sort order
     */
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserDTOFollowersList> getSortedFollowersList(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException, IncorrectOrderTypeException {
        return new ResponseEntity<>(iUserService.getSortedFollowersList(userId,order), HttpStatus.OK);
    }

    /**
     * This is the US 0004/0008 Endpoint, which enable the option to get a list of all
     * users who the user follows (Who am i following?)
     * @param userId -> the id of the user who is asked who is he following?
     * @param order -> Optional parameter which allows the user to choose a sort order
     * @return -> the user id, the user name and the lis of his followed
     * @throws UserNotFoundException -> If the user hasn't been found
     * @throws IncorrectOrderTypeException -> If the order parameter is defined with
     * an unknown sort order
     */
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserDTOFollowedList> getSortedFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException, IncorrectOrderTypeException {
        return new ResponseEntity<>(iUserService.getSortedFollowedList(userId, order),HttpStatus.OK);
    }

    /**
     * This is the US 0007 Endpoint, which enable the option to do an "unfollow"
     * to an specific user
     * @param userId -> the id of the user who will unfollow the other user
     * @param userIdToUnfollow -> the id of the user to be unfollowed
     * @return -> an status OK if all is correct, BAD_STATUS if not
     * @throws UserNotFoundException -> If the user hans't been found
     * @throws UserAlreadyUnfollowedException -> If the user actually has been
     * unfollowed or the user was never followed
     */
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<HttpStatus> unfollowAnUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UserAlreadyUnfollowedException {
        HttpStatus status=iUserService.unfollowUser(userId,userIdToUnfollow);
        return new ResponseEntity<>(status,status);
    }


}
