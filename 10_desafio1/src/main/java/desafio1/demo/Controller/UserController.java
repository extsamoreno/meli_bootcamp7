package desafio1.demo.Controller;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserDoesNotFollowException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.FollowedListDTO;
import desafio1.demo.Model.DTO.FollowersCountDTO;
import desafio1.demo.Model.DTO.FollowersListDTO;
import desafio1.demo.Service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException {
        iUserService.followUser(userId,userIdToFollow);
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UserDoesNotFollowException {
        iUserService.unfollowUser(userId,userIdToUnfollow);
        return  new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCountById(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCountById(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersListById(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersListById(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedListById(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowedListById(userId, order), HttpStatus.OK);
    }

}
