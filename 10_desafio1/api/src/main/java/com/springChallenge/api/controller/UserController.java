package com.springChallenge.api.controller;

import com.springChallenge.api.controller.exception.user.UserValidationsException;
import com.springChallenge.api.service.contract.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserValidationsException {
        iUserService.follow(userId, userIdToFollow);
    }
}
