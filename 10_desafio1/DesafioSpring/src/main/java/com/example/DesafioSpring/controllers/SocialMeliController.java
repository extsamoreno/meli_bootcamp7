package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowedByDTO;
import com.example.DesafioSpring.dto.FollowersDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class SocialMeliController {

    @Autowired
    IUserService iUserService;

//Requerimiento 1

    @PostMapping("/{followerId}/follow/{followedId}")
    public ResponseEntity<FollowDTO> followSeller(@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.followSeller(followerId, followedId), HttpStatus.OK);
    }

    //Requerimiento 2
    @GetMapping("{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    //Requerimiento 3 y 8
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers(@RequestParam(defaultValue = "name_asc") String order, @PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowers(userId, order), HttpStatus.OK);
    }

    //Requerimiento 4 y 8
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedByDTO> bringFollowedBy(@RequestParam(defaultValue = "name_asc") String order, @PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.bringFollowedBy(userId, order), HttpStatus.OK);
    }

    //Requerimiento 7
    @PostMapping("{followerId}/unfollow/{followedId}")
    public ResponseEntity<FollowDTO> unfollow(@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.unfollow(followerId, followedId), HttpStatus.OK);
    }
}
