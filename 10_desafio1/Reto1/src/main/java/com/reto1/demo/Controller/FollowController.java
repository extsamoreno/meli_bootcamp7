package com.reto1.demo.Controller;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.UserException.SameIdException;
import com.reto1.demo.Exception.UserException.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Exception.UserException.UserNotFollowException;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOCount;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFollowers;
import com.reto1.demo.Service.IFollowService;
import com.reto1.demo.Service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowController {

    @Autowired
    IFollowService iFollowService;

    @Autowired
    IPostService iPostService;

    /**
     *
     * @param userId
     * @param userIdToFollow
     * @return String name followed
     * @throws UserAlreadyFollowException
     * @throws UserIdNotFoundException
     */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followOtherUser(@PathVariable int userId,
                                                  @PathVariable int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException, SameIdException {
        String nameUser = iFollowService.followOtherUser(userId, userIdToFollow);
        return new ResponseEntity("Following to " + nameUser, HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @return UserDTOCount (Count how many followers user has
     * @throws UserIdNotFoundException
     *
     */
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<UserDTOCount> countFollower(@PathVariable int userId) throws UserIdNotFoundException, UserNotFollowException {
        return new ResponseEntity<>(iFollowService.countFollowers(userId), HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param order
     * @return UserDTOFollowers  [user with followers, Order ASC default value]
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     * @throws OrderNotFoundException
     */

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<UserDTOFollowers> orderFollowerList(@PathVariable int userId,
                                                              @RequestParam(required = false,defaultValue = "name_asc") String order)
                                                                throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException {
        return new ResponseEntity(iFollowService.orderListFollowers(order, userId), HttpStatus.OK);
    }


    /**
     *
     * @param userId
     * @param order
     * @return UserDTOFolloweds [ Who I follow, Order ASC default value]
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     * @throws OrderNotFoundException
     */
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<UserDTOFolloweds> listFolloweds(@PathVariable int userId,
                                                          @RequestParam(required = false,defaultValue = "name_asc") String order)
            throws UserIdNotFoundException, UserNotFollowException, OrderNotFoundException {
        return new ResponseEntity<>(iFollowService.orderListFolloweds(order, userId), HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param userIdToUnfollow
     * @return String name user unfollow
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     */
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String>  unFollow(@PathVariable int userId,
                                            @PathVariable int userIdToUnfollow) throws UserNotFollowException, UserIdNotFoundException {
        String userName = iFollowService.unFollow(userId, userIdToUnfollow);
        return new ResponseEntity("Has unfollow to "+userName,HttpStatus.OK);
    }


}





