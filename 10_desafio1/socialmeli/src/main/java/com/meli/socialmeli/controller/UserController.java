package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;
import com.meli.socialmeli.model.exception.IdNotFoundException;
import com.meli.socialmeli.model.exception.NonExistentFolloweException;
import com.meli.socialmeli.model.exception.NonSellerUserException;
import com.meli.socialmeli.model.exception.RepeatFollowerException;
import com.meli.socialmeli.model.service.ServiceSocialMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ServiceSocialMeli serviceSocialMeli;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public String assingFollowerTo(@PathVariable int userId, @PathVariable int userIdToFollow) throws
            NonSellerUserException, RepeatFollowerException, IdNotFoundException {
        serviceSocialMeli.setFollowerTo(userId, userIdToFollow);
        return "Ok: " + userId + " - " + userIdToFollow;
    }

    @GetMapping("/{userId}/followers/count")
    public UserSellerCountDTO getCountOfSeller(@PathVariable int userId) throws NonSellerUserException,
            IdNotFoundException {
        return serviceSocialMeli.getUserSellerCountDTO(userId);
    }

    @GetMapping("/{userId}/followers/list")
    public UserSellerListDTO getListOfSeller(@PathVariable int userId) throws NonSellerUserException,
            IdNotFoundException {
        return serviceSocialMeli.getUserSellerListDTO(userId, "");
    }

    @GetMapping("/{userId}/followed/list")
    public UserListDTO getListOfUsers(@PathVariable int userId) throws IdNotFoundException {
        return serviceSocialMeli.getUserListDTO(userId);
    }

    @GetMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public String UnassingFollowerTo(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws
            NonExistentFolloweException, NonSellerUserException, IdNotFoundException {
        serviceSocialMeli.removeFollowerTo(userId, userIdToUnfollow);
        return "OK";
    }

}
