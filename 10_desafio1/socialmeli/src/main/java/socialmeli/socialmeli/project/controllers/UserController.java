package socialmeli.socialmeli.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.UnfollowException;
import socialmeli.socialmeli.project.services.Dto.UserDto.*;
import socialmeli.socialmeli.project.services.IUserService;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable Integer userId,@PathVariable Integer userIdToFollow) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException {
        UserRequestDto userRequestDto = new UserRequestDto(userId,userIdToFollow);
        iUserService.followUser(userRequestDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("UserId: " + userId + " has succesfully followed userIdToFollow: " + userIdToFollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersResponseDto> getFollowersCount (@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersCountById(userId.toString()),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersListResponseDto> getFollowersList (@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersById(userId.toString()),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListResponseDto> getFollowedUsers (@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowedById(userId.toString()),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser (@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws IdNotFoundException, UnfollowException {
        UserUnfollowRequestDto userUnfollowRequestDto = new UserUnfollowRequestDto(userId,userIdToUnfollow);
        iUserService.unfollowUser(userUnfollowRequestDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("userId: "+userId+" has successfully unfollowed userIdToUnfollow: "+userIdToUnfollow);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
