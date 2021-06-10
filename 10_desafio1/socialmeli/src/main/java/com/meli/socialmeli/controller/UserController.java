package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.MissingParameterException;
import com.meli.socialmeli.exception.UserAlreadyFollowingUserException;
import com.meli.socialmeli.exception.UserNotExistsException;
import com.meli.socialmeli.service.IUserService;
import com.meli.socialmeli.service.dto.SellerDTO;
import com.meli.socialmeli.service.dto.UserBaseDTO;
import com.meli.socialmeli.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/addUsers")
    public ResponseEntity<Void> createUserFromList(@RequestBody List<UserBaseDTO> userList) {
        userService.createUserFromList(userList);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserBaseDTO>> getUserList() {
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotExistsException, UserAlreadyFollowingUserException {
        userService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<Integer> getFollowersAmountByUserId(@PathVariable Optional<Integer> userId) throws UserNotExistsException, MissingParameterException {
        return new ResponseEntity<>(userService.countFollowersByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerDTO> getFollowersByUserId(@PathVariable Optional<Integer> userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws UserNotExistsException, MissingParameterException {
        return new ResponseEntity<>(userService.getFollowersByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/following/list")
    public ResponseEntity<UserDTO> getFollowingByUserId(@PathVariable Optional<Integer> userId, @RequestParam(required = false, defaultValue = "name_asc") String order) throws UserNotExistsException, MissingParameterException {
        return new ResponseEntity<>(userService.getFollowingByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> UnfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotExistsException {
        userService.unfollowUser(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
