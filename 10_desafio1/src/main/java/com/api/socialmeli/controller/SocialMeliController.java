package com.api.socialmeli.controller;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.service.SocialMeliServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    @Autowired
    SocialMeliServiceImple socialMeliServiceImple;

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> US001(@PathVariable int userId,@PathVariable int userIdToFollow ) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US001(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> US002(@PathVariable int userId) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US002(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> US003(@PathVariable int userId ,
                                              @RequestParam(value="order", required=false) String order) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US003(userId, order), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFolowedDTO> US004(@PathVariable int userId,
                                                @RequestParam(value="order", required=false) String order) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US004(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/newpost")
    public ResponseEntity<String> US005(@RequestBody PostDTO newPost ) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US005(newPost), HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDTO> US006(@PathVariable int userId,
                                                  @RequestParam(value="order", required=false) String order) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US006(userId, order), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> US007(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US007(userId, userIdToUnfollow), HttpStatus.OK);
    }


}
