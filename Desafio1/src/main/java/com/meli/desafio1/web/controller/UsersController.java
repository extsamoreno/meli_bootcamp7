package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    IUserService iUserService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Integer> followRequest(@PathVariable("userId") int userId, @PathVariable("userIdToFollow") int userIdToFollow){
        System.out.println("Entró a el servicio");
        return new ResponseEntity<>(iUserService.follow(userId,userIdToFollow), HttpStatus.CREATED);

    }
}
