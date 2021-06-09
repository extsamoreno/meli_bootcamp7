package com.meli.socialmeli.controller;

import com.meli.socialmeli.Service.IUserService;
import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseCountDTO;
import com.meli.socialmeli.exception.UserInvalidException;
import com.meli.socialmeli.model.UserMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    //Punto 1
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserInvalidException {
        iUserService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Punto 2 ok
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<UserResponseCountDTO> followers(@PathVariable int userId) {
        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.ACCEPTED);
    }

//
//    //Punto 3
//    @GetMapping("/{userId}/followers/list")
//    public ResponseEntity<UserFollowerDTO> followersList(@PathVariable int userId) {
//
//        System.out.println(iUserService.getFollowersList(userId));
//        return new ResponseEntity<>(iUserService.getFollowersList(userId), HttpStatus.OK);
//    }
}

//@JsonFormat(pattern = "dd-mm-yyyy") Para el 5