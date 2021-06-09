package com.bootcamp.desafio1.controller;


import com.bootcamp.desafio1.dto.response.CountFollowersDTO;
import com.bootcamp.desafio1.dto.response.FollowedListDTO;
import com.bootcamp.desafio1.dto.response.FollowersListDTO;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    IUserService userServiceImpl;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity createFollow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException {
        userServiceImpl.createFollow(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    @ResponseStatus(HttpStatus.OK)
    public void createUnFollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException {
        userServiceImpl.createUnFollow(userId, userIdToUnfollow);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDTO> countFollowers(@PathVariable int userId) throws UserNotFoundException {
        CountFollowersDTO countFollowersDTO = userServiceImpl.countFollowers(userId);
        return new ResponseEntity(countFollowersDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> ListFollowers(@PathVariable int userId, @RequestParam(defaultValue = "") String order) throws UserNotFoundException {
        FollowersListDTO followersListDTO = userServiceImpl.listFollowers(userId, order) ;
        return new ResponseEntity(followersListDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> ListFollowed(@PathVariable int userId, @RequestParam(defaultValue = "") String order) throws UserNotFoundException {
        FollowedListDTO followedListDTO = userServiceImpl.listFollowed(userId, order) ;
        return new ResponseEntity(followedListDTO, HttpStatus.OK);
    }

}


