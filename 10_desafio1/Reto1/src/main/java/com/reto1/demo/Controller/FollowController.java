package com.reto1.demo.Controller;

import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.UserDTO;
import com.reto1.demo.Service.FollowService;
import com.reto1.demo.Service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

    @Autowired
    IFollowService iFollowService;

    /*
    * Follow other user
    * */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followOtherUser(@PathVariable int userId,
                                                 @PathVariable int userIdToFollow) throws UserIdNotFoundException {

        String nameUser = iFollowService.followOtherUser(userId, userIdToFollow);
        return new ResponseEntity("Following to "+nameUser, HttpStatus.OK);
    }

    /*
    * Count followers
    * */
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<UserDTO> countFollower(@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iFollowService.countFollowers(userId), HttpStatus.OK);
    }

}
