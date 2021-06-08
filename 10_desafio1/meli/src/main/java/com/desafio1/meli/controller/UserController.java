package com.desafio1.meli.controller;

import com.desafio1.meli.service.DTO.RequestFollowUserToUser;
import com.desafio1.meli.service.DTO.ResponseCountFollower;
import com.desafio1.meli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Boolean> setFollow(@PathVariable Integer userId,@PathVariable Integer userIdToFollow) {

        boolean status = iUserService.followUser(userId, userIdToFollow);
        if (status)
            return new ResponseEntity<Boolean>(status, HttpStatus.OK);
        return new ResponseEntity<Boolean>(status, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<ResponseCountFollower> setFollow(@PathVariable Integer userId) {

        ResponseCountFollower status = iUserService.countFollowUser(userId);
        if (status.isSucessfull() )
            return new ResponseEntity<ResponseCountFollower>(status, HttpStatus.OK);
        return new ResponseEntity<ResponseCountFollower>(status, HttpStatus.BAD_REQUEST);

    }
}
