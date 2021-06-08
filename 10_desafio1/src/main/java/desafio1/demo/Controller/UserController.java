package desafio1.demo.Controller;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserNotFoundException;
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

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollwersCountById(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<FollowersCountDTO>(iUserService.getFollowersCountById(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersListByID(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<FollowersListDTO>(iUserService.getFollowersListByID(userId),HttpStatus.OK);
    }

}
