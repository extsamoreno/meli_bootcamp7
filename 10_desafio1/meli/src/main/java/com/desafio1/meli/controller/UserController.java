package com.desafio1.meli.controller;

import com.desafio1.meli.exceptions.NotExistUser;
import com.desafio1.meli.service.DTO.*;
import com.desafio1.meli.service.IUserService;
import com.desafio1.meli.service.orderType.UserOrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    /**
     *
     * @param userId
     * @param userIdToFollow
     * @return userId follow to userIdToFollow
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Boolean> setFollow(@PathVariable Integer userId,@PathVariable Integer userIdToFollow) throws NotExistUser {
        return new ResponseEntity<Boolean>(iUserService.followUser(userId, userIdToFollow), HttpStatus.OK);

    }

    /**
     *
     * @param userId
     * @return count followers to userId
     */
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<ResponseCountFollower> setFollower(@PathVariable Integer userId) throws NotExistUser  {

        ResponseCountFollower status = iUserService.countFollowUser(userId);
        return new ResponseEntity<ResponseCountFollower>(status, HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param order
     * @return follower list to userId
     */
    @GetMapping("/{userId}/followers/list/")
    public ResponseEntity<ResponseFollowersListDTO> getFollower(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "name_desc") UserOrderType order) throws NotExistUser  {
        return new ResponseEntity<ResponseFollowersListDTO>(iUserService.listFollowerUser(userId, order), HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param order
     * @return follow list to userId
     */
    @GetMapping("/{userId}/follow/list/")
    public ResponseEntity<ResponseFollowsListDTO> getFollow(@PathVariable Integer userId,  @RequestParam(required = false, defaultValue = "name_desc") UserOrderType order) throws NotExistUser{

        return new ResponseEntity<ResponseFollowsListDTO>(iUserService.listFollowUser(userId, order), HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param userIdToUnFollow
     * @return userId unfollow to userIdToUnFollow
     */
    @GetMapping("/{userId}/unfollow/{userIdToUnFollow}/")
    public ResponseEntity<Boolean> setUnFollow(@PathVariable Integer userId,@PathVariable Integer userIdToUnFollow) throws NotExistUser {
        return new ResponseEntity<Boolean>(iUserService.unFollowUser(userId, userIdToUnFollow), HttpStatus.OK);
    }

}
