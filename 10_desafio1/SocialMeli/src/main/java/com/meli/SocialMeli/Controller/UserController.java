package com.meli.SocialMeli.controller;

import com.meli.SocialMeli.dto.CountUserFollowerDto;
import com.meli.SocialMeli.dto.CreateUserDto;
import com.meli.SocialMeli.dto.ListFollowersUserDto;
import com.meli.SocialMeli.exceptions.UserIsNotSeller;
import com.meli.SocialMeli.exceptions.UserNotFoundException;
import com.meli.SocialMeli.models.User;
import com.meli.SocialMeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private IUserService iUserService;

    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }


    @PostMapping("/users/create")
    public List<User> createUser (@RequestBody CreateUserDto createDto){
        return iUserService.CreateUser(createDto);
    }


    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> getListUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, UserIsNotSeller {
        iUserService.FollowUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userIdCount}/followers/count")
    public ResponseEntity<CountUserFollowerDto> getFollowersCount(@PathVariable int userIdCount)throws UserNotFoundException, UserIsNotSeller {
        return new ResponseEntity<>(iUserService.getFollowersCount(userIdCount), HttpStatus.OK);
    }

    @GetMapping("/users/{userIdListFollower}/followers/list")
    public ResponseEntity<ListFollowersUserDto> getListFollowers(@PathVariable int userIdListFollower){
        return new ResponseEntity<>(iUserService.getListFollowers(userIdListFollower), HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return iUserService.getUsers();
    }


}
