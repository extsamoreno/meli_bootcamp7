package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.UserDTO;
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
    public ResponseEntity<Integer> followResponse(@PathVariable("userId") int userId, @PathVariable("userIdToFollow") int userIdToFollow){
        System.out.println("Entró a el servicio");
        int respuesta = iUserService.follow(userId,userIdToFollow);
        HttpStatus status;
        if(respuesta == 1) {
             status = HttpStatus.CREATED;
        }else{
                 status = HttpStatus.BAD_REQUEST;
            }

        return new ResponseEntity<>(respuesta, status);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<CusersResponse> countResponse(@PathVariable("userId") int userId){
        return new ResponseEntity<>(iUserService.cUserFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<List<UserDTO>> ListFollowersResponse(@RequestParam(value = "order", required = false,defaultValue = "") String order,@PathVariable("userId") int userId){
        return new ResponseEntity<>(iUserService.followersByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<List<UserDTO>> ListFollowedResponse(@RequestParam(value = "order", required = false, defaultValue = "") String order,@PathVariable("userId") int userId){
        return new ResponseEntity<>(iUserService.followedByUserId(userId,order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Integer> unFollowResponse(@PathVariable("userId") int userId, @PathVariable("userIdToUnfollow") int userIdToUnfollow){

        int respuesta = iUserService.unFollow(userId,userIdToUnfollow);
        HttpStatus status;
        if(respuesta == 1) {
            status = HttpStatus.CREATED;
        }else{
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(respuesta, status);
    }
}
