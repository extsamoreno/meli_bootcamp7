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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/add")
    public ResponseEntity<?> postAdd(@RequestBody UserDTO userDTO) {

        return new ResponseEntity<>(iUserService.userAdd(userDTO), HttpStatus.OK);
    }

    @PostMapping("/add/list")
    public ResponseEntity<?> postAddList(@RequestBody List<UserDTO> userDTO) {

        return new ResponseEntity<>(iUserService.userAddList(userDTO), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> postFollow(@PathVariable int userId, @PathVariable int userIdToFollow) {

        return new ResponseEntity<>(iUserService.userFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFolCouResponseDTO> getFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFolsLisResponseDTO> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iUserService.getFollowersList(userId,order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFolLisResponseDTO> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iUserService.getFollowedList(userId,order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> postUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) {


        return new ResponseEntity<>(iUserService.userUnFollow(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
