package com.desafio.socialMeli.controllers;

import com.desafio.socialMeli.model.dto.UserFollowedDTO;
import com.desafio.socialMeli.model.dto.UserFollowersCountDTO;
import com.desafio.socialMeli.model.dto.UserFollowersDTO;
import com.desafio.socialMeli.model.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.model.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;
import com.desafio.socialMeli.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;


    @GetMapping("/loaddb")
    public ResponseEntity<String> loadDatabase() {
        return new ResponseEntity<String>(iUserService.loadDatabaseDTO(), HttpStatus.OK);
    }


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followById(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException {
        return new ResponseEntity<String>(iUserService.followById(userId, userIdToFollow), HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> followersCount(@PathVariable Integer userId) throws UserNotFoundException, RepositoryUnableException {
        return new ResponseEntity<UserFollowersCountDTO>(iUserService.followersCount(userId), HttpStatus.OK);
    }

/*
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> followersList(@PathVariable Integer userId) throws UserNotFoundException, RepositoryUnableException {
        return new ResponseEntity<UserFollowersDTO>(iUserService.followersList(userId), HttpStatus.OK);
    }



    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> followedList(@PathVariable Integer userId) throws UserNotFoundException, RepositoryUnableException {
        return new ResponseEntity<UserFollowedDTO>(iUserService.followedList(userId), HttpStatus.OK);
    }
*/
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowById(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserNotFoundException, RepositoryUnableException, RemoveFollowerException, RemoveFollowedException {
        return new ResponseEntity<String>(iUserService.unfollowById(userId, userIdToUnfollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getListOfFollowers(@PathVariable int userId, @RequestParam(name = "order", required = false, defaultValue = "name_asc") String order) throws UserNotFoundException, RepositoryUnableException {
        UserFollowersDTO userFollowersDTO = iUserService.followersList(userId, order);
        return new ResponseEntity<>(userFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getListOfFollowed(@PathVariable int userId, @RequestParam(name = "order", required = false, defaultValue = "name_asc") String order) throws UserNotFoundException, RepositoryUnableException {
        UserFollowedDTO userFollowedDTO = iUserService.followedList(userId, order);
        return new ResponseEntity<>(userFollowedDTO, HttpStatus.OK);
    }

}
