package desafio1.desafio1.controller;


import desafio1.desafio1.service.IUsersService;
import desafio1.desafio1.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUsersService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> followUser(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(userService.getUser(userIdToFollow), HttpStatus.OK);
    }






}
