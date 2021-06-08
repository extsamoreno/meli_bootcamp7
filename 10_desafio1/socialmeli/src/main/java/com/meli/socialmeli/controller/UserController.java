package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;
import com.meli.socialmeli.model.service.ServiceSocialMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ServiceSocialMeli serviceSocialMeli;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public String assingFollowerTo(@PathVariable int userId, @PathVariable int userIdToFollow) {
        serviceSocialMeli.setFollowerTo(userId, userIdToFollow);
        return "Ok: " + userId + " - " + userIdToFollow;
    }

    @GetMapping("/{userId}/followers/count")
    public UserSellerCountDTO getCountOfSeller(@PathVariable int userId) {
        return serviceSocialMeli.getUserSellerCountDTO(userId);
    }

    @GetMapping("/{userId}/followers/list")
    public UserSellerListDTO getListOfSeller(@PathVariable int userId) {
        return serviceSocialMeli.getUserSellerListDTO(userId);
    }

    @GetMapping("/{userId}/followed/list")
    public UserListDTO getListOfUsers(@PathVariable int userId) {
        return serviceSocialMeli.getUserListDTO(userId);
    }


}
