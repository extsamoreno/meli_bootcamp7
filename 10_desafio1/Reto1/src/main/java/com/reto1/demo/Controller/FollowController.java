package com.reto1.demo.Controller;

import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.UserDTOCount;
import com.reto1.demo.Model.DTO.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserDTOFollowers;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FollowController {

    @Autowired
    IFollowService iFollowService;

    /*
     * Follow other user
     * */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followOtherUser(@PathVariable int userId,
                                                  @PathVariable int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException {
        String nameUser = iFollowService.followOtherUser(userId, userIdToFollow);
        return new ResponseEntity("Following to " + nameUser, HttpStatus.OK);
    }

    /*
     * Count followers
     * */
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<UserDTOCount> countFollower(@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iFollowService.countFollowers(userId), HttpStatus.OK);
    }

    /*
     * Return user with followers
     * */
    @GetMapping("/users/{UserID}/followers/list")
    public ResponseEntity<UserDTOFollowers> listFollowes(@PathVariable int UserID) throws UserIdNotFoundException {
        return new ResponseEntity<>(iFollowService.getFollowers(UserID), HttpStatus.OK);
    }

    /*
     *  Who I follow
     * */
    @GetMapping("/users/{UserID}/followed/list")
    public ResponseEntity<UserDTOFolloweds> listFolloweds(@PathVariable int UserID) throws UserIdNotFoundException {
        return new ResponseEntity<>(iFollowService.getFolloweds(UserID), HttpStatus.OK);
    }

    //Create a post
    @PostMapping("/products/newpost")
    public ResponseEntity<String> createPost(@RequestBody Post post) throws UserIdNotFoundException {
        String postname = iFollowService.creatPost(post);
        return new ResponseEntity<>("The post " + postname + " was created", HttpStatus.OK);
    }
    
}





