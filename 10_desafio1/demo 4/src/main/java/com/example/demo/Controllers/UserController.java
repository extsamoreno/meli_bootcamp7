package com.example.demo.Controllers;

import com.example.demo.Exeptions.CustomExeption;
import com.example.demo.Services.DTO.ResponseCountFollowersDTO;
import com.example.demo.Services.SocialMeliService;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity folLowSeller(@PathVariable int userId, @PathVariable int userIdToFollow) throws CustomExeption {

        userService.addFollow(userId,userIdToFollow);
        return ResponseEntity.ok().build();
    }

    /*
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<ResponseCountFollowersDTO> countFollowers(@PathVariable int userId) throws CustomExeption {

        ResponseCountFollowersDTO response = userService.countFollowers(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/

}
