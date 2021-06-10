package com.SocialMeli.controller;

import com.SocialMeli.dtos.FollowersCountDTO;
import com.SocialMeli.dtos.FollowersListDTO;
import com.SocialMeli.dtos.UserDTO;
import com.SocialMeli.exceptions.UserIdNotFoundException;
import com.SocialMeli.exceptions.UsersCantFollowThemselvesException;
import com.SocialMeli.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   IUserService iUserService;

   //-----Usuarios que siguen a un vendedor-----Check

    @PostMapping ("/{userid}/follow/{useridtofollow}")
    public ResponseEntity<Boolean>  followUser(@PathVariable Integer userid, @PathVariable Integer useridtofollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        iUserService.follow(userid, useridtofollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // -----Cuantos usuarios siguen a un vendedor-----

    @GetMapping("/{userid}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCountById(@PathVariable int userId)
            throws UserIdNotFoundException {
        return new ResponseEntity<FollowersCountDTO>(iUserService.getFollowersCountById(userId), HttpStatus.OK);
    }

    //-----Lista de seguidores------

    @GetMapping("/{id}/followers/list")
    public ResponseEntity<FollowersListDTO> followers(@PathVariable Integer id, @RequestParam Optional<String>  order) throws UserIdNotFoundException {
        return new ResponseEntity<userid, useridtofollow>(iUserService.getFollowers(id, order), HttpStatus.OK);
    }

    @GetMapping("/{id}/following/count")
    public ResponseEntity<UserDTO> followingCount(@PathVariable Integer id) throws UserIdNotFoundException {
        return new ResponseEntity<UserDTO>(iUserService.getFollowingCount(id), HttpStatus.OK);
    }

    // Lista de los seguidos
   @GetMapping("/{id}/following/list")
    public ResponseEntity<FollowersListDTO> following(@PathVariable Integer id, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        return new ResponseEntity<FollowersListDTO>(iUserService.getFollowing(id, order), HttpStatus.OK);
    }
}
