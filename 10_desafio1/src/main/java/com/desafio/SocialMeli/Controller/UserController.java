package com.desafio.SocialMeli.Controller;

import com.desafio.SocialMeli.DTO.User.FollowedListDTO;
import com.desafio.SocialMeli.DTO.User.FollowersCountDTO;
import com.desafio.SocialMeli.DTO.User.FollowersListDTO;
import com.desafio.SocialMeli.DTO.User.UserDTO;
import com.desafio.SocialMeli.Exception.User.OrderNotFoundException;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserFollowedByHimselfException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/create/{userName}")
    public ResponseEntity<UserDTO> createUser (@PathVariable String userName)  throws UserExistsException {
        return new ResponseEntity<>(iUserService.createUser(userName), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser (@PathVariable int userId, @PathVariable int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException {
        iUserService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> getFollowersCount (@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersList (@PathVariable int UserID, @RequestParam(required = false) String order) throws UserIdNotFoundException, OrderNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersList(UserID, order), HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedList (@PathVariable int UserID, @RequestParam(required = false) String order) throws UserIdNotFoundException, OrderNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowedList(UserID, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfolllowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserFollowedByHimselfException, UserIdNotFoundException {
        iUserService.unFollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
