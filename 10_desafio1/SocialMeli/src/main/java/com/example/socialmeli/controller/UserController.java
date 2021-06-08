package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/add")
    public ResponseStatus PostAdd(@RequestBody UserDTO userDTO) {
        return iUserService.userAdd(userDTO);
    }
    @PostMapping("/add/list")
    public ResponseStatus PostAddList(@RequestBody List<UserDTO> userDTO) {
        return iUserService.userAddList(userDTO);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Boolean> postFollow(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return new ResponseEntity<>(iUserService.userFollow(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFolCouResponseDTO> getFollowersCount (@PathVariable int userId){
        return new ResponseEntity<>(iUserService.getFollowersCount(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFolsLisResponseDTO> getFollowersList (@PathVariable int userId){
        return new ResponseEntity<>(iUserService.getFollowersList(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFolLisResponseDTO> getFollowedList (@PathVariable int userId){
        return new ResponseEntity<>(iUserService.getFollowedList(userId),HttpStatus.OK);
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Boolean> postUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(iUserService.userUnFollow(userId,userIdToUnfollow), HttpStatus.OK);
    }
}
