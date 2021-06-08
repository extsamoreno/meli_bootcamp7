package meli.springchallenge.controllers;

import meli.springchallenge.dtos.FollowerCountDTO;
import meli.springchallenge.dtos.FollowListDTO;
import meli.springchallenge.exceptions.RelationNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity("pong", HttpStatus.OK);
    }

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotValidException, RelationNotValidException {

        userService.addFollower(userId, userIdToFollow);

        return new ResponseEntity("Relation added", HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/count")
    public  ResponseEntity<FollowerCountDTO> countFollowers(@PathVariable int userId) throws UserNotValidException {

        return new ResponseEntity(userService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("{userId}/followers/list")
    public ResponseEntity<FollowListDTO> getFollowers(@PathVariable int userId) throws UserNotValidException{
        return new ResponseEntity<>(userService.getFollowers(userId),HttpStatus.OK);
    }

    @GetMapping("{userId}/followed/list")
    public ResponseEntity<FollowListDTO> getFollowed(@PathVariable int userId) throws UserNotValidException{
        return new ResponseEntity<>(userService.getFollowed(userId),HttpStatus.OK);
    }





}
