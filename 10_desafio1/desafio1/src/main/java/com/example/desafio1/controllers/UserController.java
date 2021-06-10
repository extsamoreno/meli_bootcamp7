package com.example.desafio1.controllers;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.user.InvalidUserIdException;
import com.example.desafio1.exceptions.user.UserException;
import com.example.desafio1.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    /**
     * Create database of users
     * @author Sapaya Nicolás Martín
     */
    @PostMapping("/create")
    public ResponseEntity<String> followSeller() {
        return new ResponseEntity<>(iUserService.createDB(), HttpStatus.OK);
    }

    /**
     * Add a user to the database
     * @param name name of the user to add
     * @return UserDTO that contains userId and username
     * Response
     * 200 -> OK
     * @author Sapaya Nicolás Martín
     */
    @PostMapping("/newUser/{name}")
    public ResponseEntity<UserDTO> addUser(@PathVariable String name) {
        return new ResponseEntity<>(iUserService.addUser(name), HttpStatus.OK);
    }

    /**
    *   An user follow a user
    *   @param userId  number that identifies the actual user
    *   @param userIdToFollow  number that identifies the user to follow
    *   @return String which userId follow another userId
    *   Response
    *   200 -> OK
    *   400
    *   if any of the users does not exists
    *   or want to follow a user that already follow
    *   or want to follow himself/herself
    *   Example: /users/5/follow/1
    *   @author Sapaya Nicolás Martín
    */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followUser(@PathVariable int userId,
                                               @PathVariable int userIdToFollow) throws UserException {
        return new ResponseEntity<>(iUserService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }

    /**
     * An user UNfollow a user
     * @param userId  number that identifies the actual user
     * @param userIdToUnfollow  number that identifies the user to unfollow
     * @return String which userId unfollow another userId
     * Response
     * 200 -> OK
     * 400
     * if any of the users does not exists
     * or want to unfollow a user that is not following
     * or want to unfollow himself/herself
     * Example: /users/2/unfollow/1
     * @author Sapaya Nicolás Martín
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String> unfollowUser(@PathVariable int userId,
                                             @PathVariable int userIdToUnfollow) throws UserException {
        return new ResponseEntity<>(iUserService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }

    /**
     * Get the number of followers that user has
     * @param userId  number that identifies the actual user
     * @return ResponseFollowerCountDTO that contains userId, username, and quantity of followers
     * Response 200 -> OK
     * 400 -> if the user does not exists
     * Example: /users/1/followers/count/
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<ResponseFollowerCountDTO> getFollowerCount(@PathVariable int userId)
            throws InvalidUserIdException {
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    /**
     * Get the followers of the user
     * @param userId  number that identifies the actual user
     * @param order not required through request param must be name_asc or name_des
     * @return ResponseFollowerListDTO that contains
     * userId, username, and a list of followers each has userId and username
     * Response
     * 200 -> OK
     * 400
     * if the user does not exists
     * if passed through request param, order is not name_asc or name_des
     * Example:
     * /users/1/followers/list
     * /users/1/followers/list?order=name_asc   - sort alphabetically in ascending order
     * /users/1/followers/list?order=name_des   - sort alphabetically in descending order
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<ResponseFollowerListDTO> getFollowers(@PathVariable int userId,
                                                                @RequestParam(required = false,
                                                                        defaultValue = "") String order)
            throws UserException {
        return new ResponseEntity<>(iUserService.getFollowersList(userId, order), HttpStatus.OK);
    }

    /**
     * Get the sellers that the user follows
     * @param userId  number that identifies the actual user
     * @param order not required through request param must be name_asc or name_des
     * @return ResponseFollowedSellerDTO that contains
     * userId, username, and a list of followed each has userId and username
     * Response
     * 200 -> OK
     * 400
     * if the user does not exists
     * if passed through request param, order is not name_asc or name_des
     * Example:
     * /users/1/followed/list
     * /users/1/followed/list?order=name_asc    - sort alphabetically in ascending order
     * /users/1/followed/list?order=name_asc    - sort alphabetically in descending order
     * @author Sapaya Nicolás Martín
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ResponseFollowedSellerDTO> getFollowedSellers(@PathVariable int userId,
                                                                        @RequestParam(required = false,
                                                                              defaultValue = "") String order)
            throws UserException {
        return new ResponseEntity<>(iUserService.getFollowedSellers(userId, order), HttpStatus.OK);
    }
}
