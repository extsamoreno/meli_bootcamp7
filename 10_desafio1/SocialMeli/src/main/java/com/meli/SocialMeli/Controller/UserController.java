package com.meli.SocialMeli.Controller;

import com.meli.SocialMeli.DTO.CreateUserDTO;
import com.meli.SocialMeli.DTO.UserDTO;
import com.meli.SocialMeli.Service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    IUserService iUserService;

    //Inyeccion de dependencia por constructor
    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @PostMapping("/users/nuevo")
    public ResponseEntity<List<UserDTO>> createUser(@RequestBody CreateUserDTO createUserDTO){
        return new ResponseEntity<>(iUserService.newUser(createUserDTO), HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow){
        boolean followed = iUserService.followSeller(userId, userIdToFollow);
        if(!followed){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
