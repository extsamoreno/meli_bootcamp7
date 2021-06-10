package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.*;
import com.example.socialmeli.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * SocialMeli REST API - UserController
 *
 * @author Macarena Agostina Pomerantz
 */

@RestController
@RequestMapping("/socialmeli/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Creates a new user in local repository
     *
     * @param newUser the user you want to create in the local repository
     * @return the user that was created in the local repository userName and userId
     * @throws ExistentUserException if the user already exists in the local repository
     * @throws InvalidUserException if the userName provided is empty or not valid
     */

    @PostMapping("/addOne")
    public ResponseEntity<NewUserResponseDTO> addUser (@RequestBody NewUserRequestDTO newUser) throws ExistentUserException, InvalidUserException {
        return new ResponseEntity<>(userService.addUser(newUser), HttpStatus.CREATED);
    }

    /**
     * Follows a user
     *
     * @param userId the userId of the folower user
     * @param userIdToFollow the userId of the user to follow
     * @return the status and message of success in follow request
     * @throws InexistentUserException if the follower user or user to follow does not exist in the local repository
     * @throws ExistentFollowerException if the follower user already follows the user to follow
     * @throws InvalidFollowerException if a follower user wants to follow itself
     */

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowSellerResponseDTO> followSeller (@PathVariable int userId, @PathVariable int userIdToFollow) throws InexistentUserException, ExistentFollowerException, InvalidFollowerException {
        return new ResponseEntity<>(userService.followSeller(userId, userIdToFollow), HttpStatus.OK);
    }

    /**
     * Counts user followers
     *
     * @param userId the userId of the user to count its followers
     * @return the userId and userName of the user and its quantity of followers
     * @throws InexistentUserException if the user does not exist in th local repository
     */

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountResponseDTO> countFollowers (@PathVariable int userId) throws InexistentUserException {
        return new ResponseEntity<>(userService.countFollowers(userId), HttpStatus.OK);
    }

    /**
     * Lists user followers
     *
     * @param userId the userId of the user to list its followers
     * @param order the order type of the response. It can be "name_asc" or "name_desc". If nothing is sent, default value is set to "name_asc"
     * @return the userId and userName of the user and a list of its followers with their names and ids
     * @throws InexistentUserException if the user does not exist in th local repository
     * @throws InexistentNameOrderException if the order provided is not valid and it is not "name_asc" or "name_desc"
     */

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ListFollowersResponseDTO> listFollowers (@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws InexistentUserException, InexistentNameOrderException {
        return new ResponseEntity<>(userService.listFollowers(userId, order), HttpStatus.OK);
    }

    /**
     * Lists followed users
     *
     * @param userId the userId of the user to list the user it follows
     * @param order the order type of the response. It can be "name_asc" or "name_desc". If nothing is sent, default value is set to "name_asc"
     * @return the userId and userName of the user and a list of its followed users with their names and ids
     * @throws InexistentUserException if the user does not exist in th local repository
     * @throws InexistentNameOrderException if the order provided is not valid and it is not "name_asc" or "name_desc"
     */

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ListFollowedResponseDTO> listFollowed (@PathVariable int userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws InexistentUserException, InexistentNameOrderException {
        return new ResponseEntity<>(userService.listFollowed(userId, order), HttpStatus.OK);
    }

    /**
     * Unfollows a user
     *
     * @param userId the userId of the unfollower user
     * @param userIdToUnfollow the userId of the user to unfollow
     * @return the status and message of success in unfollow request
     * @throws InexistentUserException if the user does not exist in th local repository
     * @throws InexistentFollowerException if the unfollower user does not follow the user to unfollow
     */

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<FollowSellerResponseDTO> unfollowSeller (@PathVariable int userId, @PathVariable int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException {
        return new ResponseEntity<>(userService.unfollowSeller(userId, userIdToUnfollow), HttpStatus.OK);
    }

}
