package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer idUser){
        UserDTO user;
        switch (idUser){
            case 1:
                user = new UserDTO("Juan", "Gomez");
                break;
            default:
                user = new UserDTO("Beto", "Gomez");
                break;
        }
        return new ResponseEntity<>(user, HttpStatus.I_AM_A_TEAPOT);
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User userDTO){
        return new ResponseEntity<>(new User(userDTO.getName(),userDTO.getSurname()),HttpStatus.CREATED);
    }
}
