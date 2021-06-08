package com.meli.socialmeli.controller;

import com.meli.socialmeli.Service.IUserService;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.exception.UserInvalidException;
import com.meli.socialmeli.model.UserMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/user/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserInvalidException {
        iUserService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/followers/count/")
  public ResponseEntity<UserResponseDTO> followers(Integer userId){
        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.ACCEPTED);
    }




    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserMeli> followersList(@PathVariable int userId) {

        System.out.println(iUserService.getFollowersList(userId));
        return new ResponseEntity<>(iUserService.getFollowersList(userId), HttpStatus.OK);
    }
}

//@JsonFormat(pattern = "dd-mm-yyyy") Para el 5