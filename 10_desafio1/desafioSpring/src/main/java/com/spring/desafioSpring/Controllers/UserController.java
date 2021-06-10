package com.spring.desafioSpring.Controllers;

import com.spring.desafioSpring.DTOs.*;
import com.spring.desafioSpring.Exceptions.*;
import com.spring.desafioSpring.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    /** US0001 - Allows one user to follow another user
     * @param userId           id of the user who wants to follow someone
     * @param userIdToFollow   id of the user to be followed
     * @return void            with StatusCode
     * @throws UserNotFoundException
     * @throws FollowYourselfException
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable() int userId, @PathVariable() int userIdToFollow)
            throws UserNotFoundException, FollowYourselfException {

        iUserService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** US0002 - Returns the number of followers a user has
     * @param userId                  id of the user from whom such information is requested
     * @return CountUserFollowersDTO  contains id, name and number of followers of a user
     * @throws UserNotFoundException
     */
    @GetMapping("{userId}/followers/count")
    public ResponseEntity<CountUserFollowersDTO> followersCount(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.countFollowers(userId), HttpStatus.OK);
    }

    /** US0003 - US0008(order by name) - Returns the list of followers of a user
     * @param userId              id of the user from whom such information is requested
     * @param order               response list order
     * @return FollowersUserDTO   contains id, name and list followers of a user
     * @throws UserNotFoundException
     * @throws PropertyNotFoundException
     */
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<FollowersUserDTO> followersByUser(@PathVariable int userId, @RequestParam(required = false) String order)
            throws UserNotFoundException, PropertyNotFoundException {
        return new ResponseEntity<>(iUserService.followersByUser(userId, order), HttpStatus.OK);
    }

    /** US0004 - US0008(order by name) - Returns the list of followed of a user
     * @param userId              id of the user from whom such information is requested
     * @param order               response list order
     * @return FollowedUserDTO    contains id, name and list followed of a user
     * @throws UserNotFoundException
     * @throws PropertyNotFoundException
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedUserDTO> followedByUser(@PathVariable int userId, @RequestParam(required = false) String order)
            throws UserNotFoundException, PropertyNotFoundException {
        return new ResponseEntity<>(iUserService.followedByUser(userId, order), HttpStatus.OK);
    }

    /** US0007 - Allows one user to unfollow another user
     * @param userId            id of the user who wants to unfollow someone
     * @param userIdToUnfollow  id of the user to be unfollowed
     * @return void             with StatusCode
     * @throws UserNotFoundException
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable() int userId, @PathVariable() int userIdToUnfollow)
            throws UserNotFoundException {

        iUserService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
