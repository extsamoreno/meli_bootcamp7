package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowedByDTO;
import com.example.DesafioSpring.dto.FollowersDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.services.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users" )
public class SocialMeliController {

    @Autowired
    IuserService iUserService;
//punto1
    @GetMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDTO> followSeller (@PathVariable String userId, @PathVariable String userIdToFollow) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.followSeller(userId,userIdToFollow),HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> followSeller (){

        return new ResponseEntity<>(iUserService.getDatabase(), HttpStatus.OK);
    }

    //Punto 2
    @GetMapping("{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO>getFollowersCount(@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }
    // Punto 3
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<FollowersDTO>getFollowers(@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.OK);
    }
    // Punto 4
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<FollowedByDTO>getFollowedBy(@PathVariable String userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowedBy(userId), HttpStatus.OK);
    }
  // Punto 5

}
