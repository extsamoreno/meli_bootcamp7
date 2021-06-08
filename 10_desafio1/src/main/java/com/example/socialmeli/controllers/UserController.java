package com.example.socialmeli.controllers;

import com.example.socialmeli.exceptions.ExistentFollowerException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.NewUserResponseDTO;
import com.example.socialmeli.exceptions.ExistentUserException;
import com.example.socialmeli.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/socialmeli/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addOne")
    public ResponseEntity<NewUserResponseDTO> addUser (@RequestBody NewUserRequestDTO newUser) throws ExistentUserException {
        return new ResponseEntity<>(userService.addUser(newUser), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowSellerResponseDTO> followSeller (@PathVariable int userId, @PathVariable int userIdToFollow) throws InexistentUserException, ExistentFollowerException {
        return new ResponseEntity<>(userService.followSeller(userId, userIdToFollow), HttpStatus.OK);
    }

}
