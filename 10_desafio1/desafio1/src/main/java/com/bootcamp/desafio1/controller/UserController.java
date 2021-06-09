package com.bootcamp.desafio1.controller;


import com.bootcamp.desafio1.dto.CountFollowersDTO;
import com.bootcamp.desafio1.dto.FollowersListDTO;
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

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CountFollowersDTO> countFollowers(@PathVariable int userId) throws UserNotFoundException {
        CountFollowersDTO countFollowersDTO = userServiceImpl.countFollowers(userId);
        return new ResponseEntity(countFollowersDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> ListFollowers(@PathVariable int userId) throws UserNotFoundException {
        FollowersListDTO followersListDTO = userServiceImpl.listFollowers(userId) ;
        return new ResponseEntity(followersListDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowersListDTO> ListFolloweds(@PathVariable int userId) throws UserNotFoundException {

        FollowersListDTO followersListDTO = userServiceImpl.listFollowers(userId) ;
        return new ResponseEntity(followersListDTO, HttpStatus.OK);
    }


}


