package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.exception.UserException;
import com.meli.desafio1.web.exception.UserNotFoundException;
import com.meli.desafio1.web.response.CusersResponse;
import com.meli.desafio1.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    IUserService iUserService;
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followResponse(@PathVariable("userId") int userId, @PathVariable("userIdToFollow") int userIdToFollow) throws UserException {
        System.out.println("Entró a el servicio");
        iUserService.follow(userId,userIdToFollow);
        return new ResponseEntity<>("todo OK",HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CusersResponse> countResponse(@PathVariable("userId") int userId) throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.cUserFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<List<UserDTO>> ListFollowersResponse(@RequestParam(value = "order", required = false,defaultValue = "") String order,@PathVariable("userId") int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.followersByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<List<UserDTO>> ListFollowedResponse(@RequestParam(value = "order", required = false, defaultValue = "") String order,@PathVariable("userId") int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.followedByUserId(userId,order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unFollowResponse(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int userIdToUnfollow) throws UserException {

        iUserService.unFollow(userId,userIdToUnfollow);


        return new ResponseEntity<>("todo OK", HttpStatus.OK);
    }
}
