package com.example.socialmeli.repositories;

import com.example.socialmeli.dtos.*;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;

public interface ISocialRepository {
    MerchantDTO followMerchant(Integer userid,Integer merchantid) throws Exception;
    FollowersCountDTO followersCount(Integer merchantid, String name) throws MerchantNotFoundException;
    FollowersListDTO followersList(Integer merchantid, String name) throws MerchantNotFoundException;
    FollowedByMeListDTO followedByMe(Integer merchantid, String name) throws UserNotFoundException;
    UserDTO getUserById(int userId);
    MerchantDTO getMerchantById(int merchantId);
    void unfollow(Integer userId,Integer userIdToUnfollow) throws MerchantNotFoundException, UserNotFoundException;
}
