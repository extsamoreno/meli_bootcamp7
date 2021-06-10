package desafio1.desafio1.controller;


import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.productException.UnfollowException;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.exception.userException.ValidateUserException;
import desafio1.desafio1.service.userService.IUsersService;
import desafio1.desafio1.service.userService.dto.SellerCountDTO;
import desafio1.desafio1.service.userService.dto.SellerListDTO;
import desafio1.desafio1.service.userService.dto.UserListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUsersService userService;

    //me sobreescribe la lista y no se agregan uno despues del otro, no encuentro el problema porque puse add en todos lados creo
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<User> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException {
        return new ResponseEntity<>(userService.follow(userId, userIdToFollow), HttpStatus.OK);
    }//devuelvo un usuario solo para verificar

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerCountDTO> countFollowersUsurs(@PathVariable int userId) throws UserNotFoundException, ValidateSellerException {
        return new ResponseEntity<>(userService.countFollowersUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/{userID}/followers/list")
    public ResponseEntity<SellerListDTO> listFollowersSeller(@PathVariable int userID) throws UserNotFoundException, ValidateSellerException {
        return new ResponseEntity<>(userService.listFollowersSeller(userID), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserListDTO> listFollowedUser(@PathVariable int userId) throws UserNotFoundException, ValidateUserException {
        return new ResponseEntity<>(userService.listFollowedUser(userId), HttpStatus.OK);
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException {
        userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
