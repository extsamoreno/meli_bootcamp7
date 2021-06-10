package com.example.challenge.Controllers;

import com.example.challenge.Exceptions.*;
import com.example.challenge.Services.DTOs.*;
import com.example.challenge.Services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    //Load HardCode Data
    @PostMapping("/load")
    public ResponseEntity<String> create() throws UserNotFoundException, PostDuplicateException {
        return new ResponseEntity<>(iUserService.loadUser(), HttpStatus.OK);
    }

    // Get a list with all the users (useful to check changes)
    @GetMapping
    public ResponseEntity<List<GetUserDTO>> getUsers() {

        return new ResponseEntity<>(iUserService.getUsers(), HttpStatus.OK);
    }

/*
        Follow a user
       @param userId indicate the the id of user that want to follow an other user
       @param userIdToFollow indicate the id of the user that userId wants to follow
       @return FollowDTO  "followerID": 3,
                          "followedID": 5,
                          "type": "Follow"
       @throws UserNotFoundException if some of the ids are not found in the repository
       @throws UserAlreadyFollowException,  if the userId already is following a userIdToFollow
       @throws UserSameIdException if the userId is the same as userIdToFollow

*/
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDTO> follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserSameIdException {

        return new ResponseEntity<>(iUserService.followUser(userId, userIdToFollow), HttpStatus.OK);
    }


    /*
        Unfollow a user
       @param userId indicate the the id of user that want to unfollow an other user
       @param userIdToFollow indicate the id of the user that userId wants to be unfollow
       @return FollowDTO  "followerID": 3,
                          "followedID": 5,
                          "type": "Unfollow"
       @throws UserNotFoundException if some of the ids are not found in the repository
       @throws UserAlreadyFollowException,  if the userId already is not following a userIdToFollow
       @throws UserSameIdException if the userId is the same as userIdToFollow

*/
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<FollowDTO> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UserNotFollowException, UserSameIdException {

        return new ResponseEntity<>(iUserService.unfollowUser(userId, userIdToUnfollow), HttpStatus.OK);
    }


    /*
        Followers count
       @param userId indicate the the id of user that want to know how many followers has
       @return FollowerCountDTO  {
                                    "id": 1,               //userId
                                    "name": "Ana",         //userName
                                    "count": 4             // how many followers has
                                  }
       @throws UserNotFoundException if the userID is not found in the repository

*/
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getFollowersCount(@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    /*
        Followers List
       @param userId indicate the the id of user that want to know the followers
       @return FollowersDTO    {
                                "id": 1,
                                "userName": "Ana",
                                "followers": [
                                    {
                                        "id": 4,
                                        "name": "Lucia"
                                    },
                                    {
                                        "id": 2,
                                        "name": "Juan"
                                    }
                                ]
                            }
       @throws UserNotFoundException if the userID is not found in the repository

*/

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers(@PathVariable int userId, @RequestParam(required = false,
            defaultValue = "") String order) throws UserNotFoundException, InvalidOrderException {

        return new ResponseEntity<>(iUserService.getFollowers(userId, order), HttpStatus.OK);

    }

    /*
       Followed List
      @param userId indicate the the id of user that want to know the followed
      @return FollowersDTO    {
                               "id": 1,
                               "userName": "Ana",
                               "followed": [
                                   {
                                       "id": 4,
                                       "name": "Lucia"
                                   },
                                   {
                                       "id": 2,
                                       "name": "Juan"
                                   }
                               ]
                           }
      @throws UserNotFoundException if the userID is not found in the repository

*/
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(@PathVariable int userId, @RequestParam(required = false,
            defaultValue = "") String order) throws UserNotFoundException, InvalidOrderException {

        return new ResponseEntity<>(iUserService.getFollowed(userId, order), HttpStatus.OK);

    }


}