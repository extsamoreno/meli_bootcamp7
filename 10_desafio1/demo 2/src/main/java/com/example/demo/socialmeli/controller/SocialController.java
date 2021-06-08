package com.example.demo.socialmeli.controller;

import com.example.demo.socialmeli.service.IUserService;
import com.example.demo.socialmeli.service.UserService;
import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class SocialController {
    @Autowired
    IUserService iUserService;
    @PostMapping("/{userid}/follow/{useridtofollow}")
    public HttpStatus follow (@PathVariable int userid, @PathVariable int useridtofollow) {
        return iUserService.follow(userid,useridtofollow);
    }
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<CountFollowersDTO>  countFollowers (@PathVariable int userId) {
        return new ResponseEntity<CountFollowersDTO>( iUserService.countFollowers(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable int userId) {
        return new ResponseEntity<FollowersListDTO>( iUserService.followerList(userId),HttpStatus.OK);
    }
}
