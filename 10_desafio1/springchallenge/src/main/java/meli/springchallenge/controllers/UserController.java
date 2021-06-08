package meli.springchallenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity("pong", HttpStatus.OK);
    }

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId,@PathVariable int userIdToFollow){

        return new ResponseEntity("OK", HttpStatus.OK);
    }

}
