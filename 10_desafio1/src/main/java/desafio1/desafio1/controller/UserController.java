package desafio1.desafio1.controller;


import desafio1.desafio1.exception.UserNotFoundException;
import desafio1.desafio1.exception.ValidateSellerException;
import desafio1.desafio1.service.IUsersService;
import desafio1.desafio1.service.dto.SellerDTO;
import desafio1.desafio1.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUsersService userService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<UserDTO> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerDTO> countFollowers(@PathVariable int userId) throws UserNotFoundException, ValidateSellerException {
        return new ResponseEntity<>(userService.countFollowersById(userId), HttpStatus.OK);
    }



}
