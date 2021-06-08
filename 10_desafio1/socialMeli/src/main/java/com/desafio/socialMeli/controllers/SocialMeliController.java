package com.desafio.socialMeli.controllers;

import com.desafio.socialMeli.service.IUserService;
import com.desafio.socialMeli.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class SocialMeliController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/loaddb")
    public ResponseEntity<String> loadDatabase() {
        return new ResponseEntity<String>(iUserService.loadDatabaseDTO(), HttpStatus.OK);
    }


    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followById(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return new ResponseEntity<String>(iUserService.followById(userId, userIdToFollow), HttpStatus.OK);
    }

}
