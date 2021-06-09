package com.meli.socialmeli.controllers;

import com.meli.socialmeli.dto.FollowDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    //Punto 1 LISTO
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDTO> followMerchant(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserInvalidException {
        return new ResponseEntity<>(iUserService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    //Punto 2 Listo
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<UserFollowerCount> followers(@PathVariable int userId) {
        return new ResponseEntity<>(iUserService.getFollowerCount(userId), HttpStatus.ACCEPTED);
    }

    //Punto 3 Listo
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowerListDTO> followersList(@PathVariable int userId) {

        //System.out.println(iUserService.getFollowersList(userId));
        return new ResponseEntity<>(iUserService.getFollowerList(userId), HttpStatus.OK);
    }

    // Punto 4
//    @GetMapping("{userId}/followed/list")
//    public ResponseEntity<FollowedByDTO>getFollowedBy(@PathVariable String userId) throws UserNotFoundException {
//        return new ResponseEntity<>(iUserService.getFollowedBy(userId), HttpStatus.OK);
//    }
}
