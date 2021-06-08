package socialmeli.socialmeli.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialmeli.socialmeli.project.exceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.FollowersResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserRequestDto;
import socialmeli.socialmeli.project.services.IUserService;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId,@PathVariable Integer userIdToFollow) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException {
        UserRequestDto userRequestDto = new UserRequestDto(userId,userIdToFollow);
        iUserService.followUser(userRequestDto);
       ArrayList<String> response = new ArrayList<>();
        response.add("UserId: " + userId + " has succesfully followed userIdToFollow: " + userIdToFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersResponseDto> getFollowersCount (@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCountById(userId.toString()),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersListResponseDto> getFollowersList (@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersById(userId.toString()),HttpStatus.OK);
    }

/*    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedUsersResponseDto> getFollowedUsers ();*/

}
