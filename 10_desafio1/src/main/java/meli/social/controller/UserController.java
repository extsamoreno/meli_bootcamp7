package meli.social.controller;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.model.UserModel;
import meli.social.service.UserService;
import meli.social.service.dto.UserFollowedListDTO;
import meli.social.service.dto.UserFollowersCounterDTO;
import meli.social.service.dto.UserFollowersListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    UserService userService;

    // ------------------------- ENDPOINTS PARA VERIFICAR SEEDS -------------------------
    @GetMapping()
    public List<UserModel> allUsers (){
        return userService.getAllUsers();
    }

    // ------------------------------ ENDPOINTS FUNCIONALES ------------------------------

    @PostMapping("{userId}/follow/{userIdToFollow}")
    public HttpStatus followUser (@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserIdNotFoundException {
        userService.setFollower(userId, userIdToFollow);
        return HttpStatus.OK;
    }

    @PostMapping("{userId}/unfollow/{userIdToUnfollow}")
    public HttpStatus unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserIdNotFoundException {
        userService.removeFollower(userId, userIdToUnfollow);
        return HttpStatus.OK;
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCounterDTO> countFollowers (@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(userService.getFollowersCounter(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersListDTO>
    listFollowers (@PathVariable int userId, @RequestParam(defaultValue = "") String order) throws UserIdNotFoundException {
        return new ResponseEntity<>(userService.getFollowersList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedListDTO> listFollowed (@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(userService.getFollowedList(userId), HttpStatus.OK);
    }
}
