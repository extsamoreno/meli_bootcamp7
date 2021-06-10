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

    //US 0001: Follow a user
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> US001(@PathVariable int userId,@PathVariable int userIdToFollow ) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US001(userId,userIdToFollow), HttpStatus.OK);
    }

    //US 0002: Followers count
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> US002(@PathVariable int userId) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US002(userId), HttpStatus.OK);
    }

    //US 0003: Followers list - US 0008: Sort by name alphabetically ascending and descending
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> US003(@PathVariable int userId ,
                                              @RequestParam(value="order", required=false) String order) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US003(userId, order), HttpStatus.OK);
    }

    //US 0004: Followed list - US 0008: Sort by name alphabetically ascending and descending
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserFolowedDTO> US004(@PathVariable int userId,
                                                @RequestParam(value="order", required=false) String order) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US004(userId, order), HttpStatus.OK);
    }

    //US 0005: Create new post - US 0010: Add promotion attributes
    @PostMapping("/products/newpost")
    public ResponseEntity<String> US005(@RequestBody PostDTO newPost ) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US005(newPost), HttpStatus.OK);
    }

    //US 0006: Last two weeks post of followed users sorted by date - US 0009: Sort by date ascending and descending
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDTO> US006(@PathVariable int userId,
                                                  @RequestParam(value="order", required=false) String order) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US006(userId, order), HttpStatus.OK);
    }

    //US 0007: Unfollow a user
    @GetMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> US007(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US007(userId, userIdToUnfollow), HttpStatus.OK);
    }

    //US 0011: Count posts with promotion
    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<CountPromoDTO> US011(@PathVariable int userId) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US011(userId), HttpStatus.OK);
    }

    //US 0012: User posts list with promotion
    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<PostPromoDTO> US012(@PathVariable int userId) throws Exception {
        return new ResponseEntity<>(socialMeliServiceImple.US012(userId), HttpStatus.OK);
    }

}
