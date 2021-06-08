package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.UserNotFoundException;
import com.meli.desafio.models.User;
import com.meli.desafio.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.models.dto.ResponseUserListFollowers;
import com.meli.desafio.services.IUserService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    //user follow user2
    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> addNewFollow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        userService.addNewFollow(userId, userIdToFollow);
        return new ResponseEntity<>(URLBuilder.buildURL("users", userId, "followers/list"), HttpStatus.OK);
    }

    //-------------------------//
    //    ALGO ANDA MAL        //
    //-------------------------//
    //followers count of user
    @GetMapping(value = {"/{userId}{userName}/followers/count"})
    public ResponseEntity<ResponseUserCountFollowers> showCountFollowers(
            @PathVariable Optional<Integer> userId,
            @PathVariable Optional<String> userName
    ) throws UserNotFoundException {
        return new ResponseEntity<>(userService.showCountFollowers(userId, userName), HttpStatus.OK);
    }



    //TENGO QUE HACER LO MISMO QUE CON EL DE ARRIBA (CUANDO FUNCIONE)
    //Followers list of user
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseUserListFollowers> showAllFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.showAllFollowers(userId), HttpStatus.OK);
    }

    //followed list of user
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<User> showAllFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.showAllFollowed(userId), HttpStatus.OK);
    }
}
