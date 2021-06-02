package com.example.Ejercicio_1.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController {
    //http://localhost:8080/users/1
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer iduser){
        User user;
        switch (iduser){
            case 1:

                user=new User(iduser,"juan","gomez",new ArrayList<>());
                break;
            default:
                user=new User(iduser,"matia","test",new ArrayList<>());
                break;

        }
        return user;

    }

    @GetMapping("/DTO/{ids}")
    public UserDTO getUserDTOById(@PathVariable("ids") Integer iduser){
        UserDTO user;
        switch (iduser){
            case 1:

                user=new UserDTO("juan","gomez");
                break;
            default:
                user=new UserDTO("matia","test");
                break;

        }
        return user;

    }

    @GetMapping("/Grapper/{ids}")
    public ResponseEntity<UserDTO> geGrapperById(@PathVariable("ids") Integer iduser){
        UserDTO user;
        switch (iduser){
            case 1:

                user=new UserDTO("juan","gomez");
                break;
            default:
                user=new UserDTO("matia","test");
                break;

        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    /*{
    "name": "lucas",
    "surname": "perez"

    }*/

    @PostMapping("/Create")
    public ResponseEntity<User> CreateUser(@RequestBody UserDTO userdto){
        return new ResponseEntity<>(new User(userdto.getName(),userdto.getSurname()), HttpStatus.CREATED);
    }
}

