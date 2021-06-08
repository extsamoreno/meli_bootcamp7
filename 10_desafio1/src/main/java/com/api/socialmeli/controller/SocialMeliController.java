package com.api.socialmeli.controller;

import com.api.socialmeli.dto.FollowersCountDTO;
import com.api.socialmeli.dto.FollowersDetailDTO;
import com.api.socialmeli.service.SocialMeliServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SocialMeliController {

    @Autowired
    SocialMeliServiceImple socialMeliServiceImple;

    @GetMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> US001(@PathVariable int userId,@PathVariable int userIdToFollow ){
        return new ResponseEntity<>(socialMeliServiceImple.US001(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> US002(@PathVariable int userId){
        return new ResponseEntity<>(socialMeliServiceImple.US002(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDetailDTO> US003(@PathVariable int userId){
        return new ResponseEntity<>(socialMeliServiceImple.US003(userId), HttpStatus.OK);
    }


}
