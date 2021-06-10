package com.example.socialmeli.controllers;

import com.example.socialmeli.dtos.user.FollowedByMeListDTO;
import com.example.socialmeli.dtos.user.FollowersCountDTO;
import com.example.socialmeli.dtos.user.FollowersListDTO;
import com.example.socialmeli.dtos.user.MerchantDTO;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.services.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/social")
public class SocialController {
    @Autowired
    private ISocialService socialService;

    /**
     *
     * @param userid
     * @param merchantid
     * @return MerchantDTO (list of merchants that de userid follow)
     * @throws Exception
     */
    @PostMapping("/users/{userid}/follow/{merchantid}")
    public ResponseEntity<MerchantDTO> followMerchant(@PathVariable Integer userid, @PathVariable Integer merchantid) throws Exception {
        return new ResponseEntity<MerchantDTO>(socialService.followMerchant(userid,merchantid), HttpStatus.OK);
    }

    /**
     *
     * @param merchantid
     * @param name
     * @return FollowersCountDTO (count of followers that merchant have)
     * @throws MerchantNotFoundException
     */
    @GetMapping("/user/{merchantid}/followers/count/")
    public ResponseEntity<FollowersCountDTO> followersCountById(@PathVariable Integer merchantid,
                                                                @RequestParam(required = false, defaultValue = "") String name) throws MerchantNotFoundException {
        return new ResponseEntity<FollowersCountDTO>(socialService.followersCount(merchantid, name),HttpStatus.OK);
    }

    /**
     *
     * @param merchantid
     * @param name
     * @param order
     * @return FollowersListDTO (list of followers that merchant have)
     * @throws MerchantNotFoundException
     */
    @GetMapping("/user/{merchantid}/followers/list")
    public ResponseEntity<FollowersListDTO> followersListById(@PathVariable Integer merchantid,
                                                              @RequestParam(required = false, defaultValue = "") String name,
                                                              @RequestParam(required = false) String order) throws MerchantNotFoundException {
        return new ResponseEntity<FollowersListDTO>(socialService.followersList(merchantid, name, order),HttpStatus.OK);
    }

    /**
     *
     * @param userid
     * @param name
     * @return FollowedByMeListDTO (list of merchants that user follow)
     * @throws UserNotFoundException
     */
    @GetMapping("/user/{userid}/followed/list")
    public ResponseEntity<FollowedByMeListDTO> myFollowsList(@PathVariable Integer userid,
                                                             @RequestParam(required = false, defaultValue = "") String name) throws UserNotFoundException {
        return new ResponseEntity<FollowedByMeListDTO>(socialService.followedByMe(userid, name),HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param userIdToUnfollow
     * @return HttpStatus (return OK if the unfollow was successful)
     * @throws UserNotFoundException
     * @throws MerchantNotFoundException
     */
    @PostMapping("/user/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<HttpStatus> unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws UserNotFoundException, MerchantNotFoundException {
        return new ResponseEntity<HttpStatus>(socialService.unfollow(userId,userIdToUnfollow),HttpStatus.OK);
    }
}
