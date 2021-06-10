package desafio1.desafio1.controller;


import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.*;
import desafio1.desafio1.service.userService.IUsersService;
import desafio1.desafio1.service.userService.dto.SellerCountDTO;
import desafio1.desafio1.service.userService.dto.SellerListDTO;
import desafio1.desafio1.service.userService.dto.UserListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUsersService userService;


    /**
     * Allows a user(userId) to follow a seller/user(UserIdToFollow).
     * @param userId
     * @param userIdToFollow
     * @return
     * @throws UserNotFoundException
     * @throws FollowException
     * @throws FollowLoopException
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, FollowException, FollowLoopException {
        userService.follow(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Allows you to know the number of users who follow a seller(userId).
     * @param userId
     * @return
     * @throws UserNotFoundException
     * @throws ValidateSellerException
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerCountDTO> countFollowersUsurs(@PathVariable int userId) throws UserNotFoundException, ValidateSellerException {
        return new ResponseEntity<>(userService.countFollowersUserById(userId), HttpStatus.OK);
    }

    /**
     * Lets you know a list of users who follow a seller(userId). Optionally you can add a criterion of order name_asc or name_desc
     * @param userID
     * @param order
     * @return
     * @throws UserNotFoundException
     * @throws ValidateSellerException
     */
    @GetMapping("/{userID}/followers/list")
    public ResponseEntity<SellerListDTO> listFollowersSeller(@PathVariable int userID , @RequestParam(required = false) String order) throws UserNotFoundException, ValidateSellerException {
        return new ResponseEntity<>(userService.listFollowersSeller(userID, order), HttpStatus.OK);
    }

    /**
     *It allows you to know a list of sellers that a user(userId) follows. Optionally you can add a criterion of order name_asc or name_desc
     * @param userId
     * @param order
     * @return
     * @throws UserNotFoundException
     * @throws ValidateUserException
     */
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserListDTO> listFollowedUser(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException, ValidateUserException {
        return new ResponseEntity<>(userService.listFollowedUser(userId, order), HttpStatus.OK);
    }


    /**
     * allows a user/seller(userId) to unfollow a seller(userIdToUnfollow)
     * @param userId
     * @param userIdToUnfollow
     * @return
     * @throws UserNotFoundException
     * @throws UnfollowException
     * @throws ValidateSellerException
     */
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException {
        userService.unfollow(userId, userIdToUnfollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
