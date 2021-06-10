package com.reto1.demo.Controller;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Exception.UserNotFollowException;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOCount;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFolloweds;
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
    /*
     * Follow other user
     * */
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> followOtherUser(@PathVariable int userId,
                                                  @PathVariable int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException  {
        String nameUser = iFollowService.followOtherUser(userId, userIdToFollow);
        return new ResponseEntity("Following to " + nameUser, HttpStatus.OK);
    }

    /*
     * Count followers
     * */
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<UserDTOCount> countFollower(@PathVariable int userId) throws UserIdNotFoundException, UserNotFollowException {
        return new ResponseEntity<>(iFollowService.countFollowers(userId), HttpStatus.OK);
    }

    /*
     * Return user with followers, Order ASC default value
     * */

    @GetMapping("/users/{UserID}/followers/list")
    public ResponseEntity<UserDTOFolloweds> orderFollowerList(@PathVariable int UserID,
                                                              @RequestParam(required = false,defaultValue = "name_asc") String order)
                                                                throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException {
        return new ResponseEntity(iFollowService.orderListFollowers(order, UserID), HttpStatus.OK);
    }

    /*
     *  Who I follow, Order ASC default value
     */
    @GetMapping("/users/{UserID}/followed/list")
    public ResponseEntity<UserDTOFolloweds> listFolloweds(@PathVariable int UserID,
                                                          @RequestParam(required = false,defaultValue = "name_asc") String order)
            throws UserIdNotFoundException, UserNotFollowException, OrderNotFoundException {
        return new ResponseEntity<>(iFollowService.orderListFolloweds(order, UserID), HttpStatus.OK);
    }

    //UnFollow
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<String>  unFollow(@PathVariable int userId,
                                            @PathVariable int userIdToUnfollow) throws UserNotFollowException, UserIdNotFoundException {
        String userName = iFollowService.unFollow(userId, userIdToUnfollow);
        return new ResponseEntity("Has unfollow to "+userName,HttpStatus.OK);
    }


    /*
     * Crear función donde pueda editar los post
     * Equals user
     * */



}





