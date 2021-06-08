package com.desafio.SocialMeli.Controller;

import com.desafio.SocialMeli.DTO.FollowedListDTO;
import com.desafio.SocialMeli.DTO.FollowersCountDTO;
import com.desafio.SocialMeli.DTO.FollowersListDTO;
import com.desafio.SocialMeli.DTO.UserDTO;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserFollowedByHimselfException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iSocialMeliService;

    @PostMapping("/create/{userName}")
    public ResponseEntity<UserDTO> createUser (@PathVariable String userName)  throws UserExistsException {
        return new ResponseEntity<>(iSocialMeliService.createUser(userName), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity followUser (@PathVariable int userId, @PathVariable int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException {
        iSocialMeliService.followUser(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowersCountDTO> getFollowersCount (@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iSocialMeliService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followers/list")
    public ResponseEntity<FollowersListDTO> getFollowersList (@PathVariable int UserID) throws UserIdNotFoundException {
        return new ResponseEntity<>(iSocialMeliService.getFollowersList(UserID), HttpStatus.OK);
    }

    @GetMapping("/{UserID}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedList (@PathVariable int UserID) throws UserIdNotFoundException {
        return new ResponseEntity<>(iSocialMeliService.getFollowedList(UserID), HttpStatus.OK);
    }


}
