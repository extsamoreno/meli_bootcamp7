package com.example.socialmeli.repositories;

import com.example.socialmeli.dtos.FollowedByMeListDTO;
import com.example.socialmeli.dtos.FollowersCountDTO;
import com.example.socialmeli.dtos.FollowersListDTO;
import com.example.socialmeli.dtos.MerchantDTO;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;

public interface ISocialRepository {
    MerchantDTO createMerchant(String name);
    MerchantDTO followMerchant(Integer userid,Integer merchantid) throws Exception;
    FollowersCountDTO followersCount(Integer merchantid, String name) throws MerchantNotFoundException;
    FollowersListDTO followersList(Integer merchantid, String name) throws MerchantNotFoundException;
    FollowedByMeListDTO followedByMe(Integer merchantid, String name) throws MerchantNotFoundException, UserNotFoundException;
}
