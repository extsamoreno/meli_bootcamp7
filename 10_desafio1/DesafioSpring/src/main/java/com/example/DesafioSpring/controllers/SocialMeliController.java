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
@RequestMapping("/users" )
public class SocialMeliController {

    @Autowired
    IUserService iUserService;



    @PostMapping("/{followerId}/follow/{followedId}")
    public ResponseEntity<FollowDTO> followSeller (@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.followSeller(followerId, followedId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount (@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers (@RequestParam(defaultValue="name_desc") String order,@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowers(userId,order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedByDTO> getFollowed (@RequestParam(defaultValue="name_desc") String order,@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowed(userId,order), HttpStatus.OK);
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> followSeller (){

        return new ResponseEntity<>(iUserService.getdb(), HttpStatus.OK);
    }
    @PostMapping("{followerId}/unfollow/{followedId}")
    public ResponseEntity<FollowDTO> unfollow (@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.unfollow(followerId, followedId), HttpStatus.OK);
    }
}
