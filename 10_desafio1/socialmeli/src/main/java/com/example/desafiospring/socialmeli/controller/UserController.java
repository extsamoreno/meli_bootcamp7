package com.example.desafiospring.socialmeli.controller;

import com.example.desafiospring.socialmeli.service.IUserService;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

//0001 realizar la acción de follow a determinado X user
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable Integer userId , @PathVariable Integer userIdToFollow) throws UserNotFoundException {
        userService.followUser(userId,userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

//0002 obtener la cantidad de user que siguen a X vendedor
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserDTO> getUserFollowersCount(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowersCount(userId),HttpStatus.OK);
    }

//0003 obtener un listado de los users que siguen a determinado vendedor/user
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserDTO> getUserFollowers(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowers(userId),HttpStatus.OK);
    }

//0004 obtener un listado de a quien sigo
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserDTO> getUserFollowed(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserFollowed(userId),HttpStatus.OK);
    }

//0007 para realizar la acción de dejar de seguir a un user determinado
    @PostMapping("/{userId}/unfollow/{userIdToUnFollow}")
    public ResponseEntity unFollowUser(@PathVariable Integer userId , @PathVariable Integer userIdToUnFollow) throws UserNotFoundException {
        userService.unFollowUser(userId,userIdToUnFollow);
        return new ResponseEntity(HttpStatus.OK);
    }

}
