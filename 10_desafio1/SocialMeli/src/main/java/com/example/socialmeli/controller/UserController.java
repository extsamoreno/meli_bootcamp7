package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.exceptions.UserFollowthisUserException;
import com.example.socialmeli.exceptions.UserIdNotFountException;
import com.example.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    //US 0001   follow
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> postFollow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserFollowthisUserException {
        return new ResponseEntity<>(iUserService.userFollow(userId, userIdToFollow), HttpStatus.OK);
    }

    //US 0002   get count followeb by user id
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFolCouResponseDTO> getFollowersCount(@PathVariable int userId) throws UserIdNotFountException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    // US 0003 get all user followers by user id
    // US 0008 Order by name asc-desc
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFolsLisResponseDTO> getFollowersList(@PathVariable int userId, @RequestParam(required = false) String order) throws UserIdNotFountException {
        return new ResponseEntity<>(iUserService.getFollowersList(userId, order), HttpStatus.OK);
    }

    // US 0004 get all user followed by user id
    // US 0008 Order by name asc-desc
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFolLisResponseDTO> getFollowedList(@PathVariable int userId, @RequestParam(required = false) String order) throws UserIdNotFountException {
        return new ResponseEntity<>(iUserService.getFollowedList(userId, order), HttpStatus.OK);
    }

    // US 0007 unfollow
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> postUnfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserFollowthisUserException {
        return new ResponseEntity<>(iUserService.userUnFollow(userId, userIdToUnfollow), HttpStatus.OK);
    }

    //Additional Endpoint

    // Add new User in list memory
    @PostMapping("/add")
    public ResponseEntity<?> AddUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(iUserService.userAdd(userDTO), HttpStatus.OK);
    }

    // Add new list User in list memory
    @PostMapping("/add/list")
    public ResponseEntity<?> AddUserList(@RequestBody List<UserDTO> userDTO) {
        return new ResponseEntity<>(iUserService.userAddList(userDTO), HttpStatus.OK);
    }

}
