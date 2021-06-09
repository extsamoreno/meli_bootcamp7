package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;
import com.meli.socialmeli.model.exception.*;
import com.meli.socialmeli.model.service.ServiceSocialMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ServiceSocialMeli serviceSocialMeli;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> assingFollowerTo(@PathVariable int userId, @PathVariable int userIdToFollow)
            throws NonSellerUserException, RepeatFollowerException, IdNotFoundException, SellerCanNotFollowException {
        serviceSocialMeli.setFollowerTo(userId, userIdToFollow);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserSellerCountDTO> getCountOfSeller(@PathVariable int userId)
            throws NonSellerUserException, IdNotFoundException {
        return new ResponseEntity<>(serviceSocialMeli.getUserSellerCountDTO(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserSellerListDTO> getListOfSeller(@PathVariable int userId,
                                                             @RequestParam(name = "order", required = false,
                                                                     defaultValue = "name_asc") String order)
            throws NonSellerUserException, IdNotFoundException, ErrorOrderParamNameException {
        return new ResponseEntity<>(serviceSocialMeli.getUserSellerListDTO(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserListDTO> getListOfUsers(@PathVariable int userId,
                                                      @RequestParam(name = "order",
                                                              required = false, defaultValue = "name_asc") String order)
            throws IdNotFoundException, ErrorOrderParamNameException, SellerCanNotFollowException {
        return new ResponseEntity<>(serviceSocialMeli.getUserListDTO(userId, order), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> UnassingFollowerTo(@PathVariable int userId, @PathVariable int userIdToUnfollow)
            throws NonExistentFolloweException, NonSellerUserException, IdNotFoundException, SellerCanNotFollowException {
        serviceSocialMeli.removeFollowerTo(userId, userIdToUnfollow);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
