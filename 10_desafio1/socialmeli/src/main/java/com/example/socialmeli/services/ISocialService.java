package com.example.socialmeli.services;

import com.example.socialmeli.dtos.*;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;

public interface ISocialService {
    MerchantDTO followMerchant(Integer userid,Integer merchantid) throws Exception;
    FollowersCountDTO followersCount(Integer merchantid, String name) throws MerchantNotFoundException;
    FollowersListDTO followersList(Integer merchantid, String name) throws MerchantNotFoundException;
    FollowedByMeListDTO followedByMe(Integer merchantid, String name) throws UserNotFoundException;
}
