package com.example.socialmeli.services;

import com.example.socialmeli.dtos.*;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.repositories.ISocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SocialService implements  ISocialService{

    @Autowired
    private ISocialRepository socialRepository;

    @Override
    public MerchantDTO followMerchant(Integer userid, Integer merchantId) throws Exception {
        return socialRepository.followMerchant(userid, merchantId);
    }

    @Override
    public FollowersCountDTO followersCount(Integer merchantid, String name) throws MerchantNotFoundException {
        return socialRepository.followersCount(merchantid, name);
    }

    @Override
    public FollowersListDTO followersList(Integer merchantid, String name) throws MerchantNotFoundException {
        return socialRepository.followersList(merchantid, name);
    }

    @Override
    public FollowedByMeListDTO followedByMe(Integer merchantid, String name) throws UserNotFoundException {
        return socialRepository.followedByMe(merchantid, name);
    }

    @Override
    public HttpStatus unfollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException, MerchantNotFoundException {
        socialRepository.unfollow(userId,userIdToUnfollow);
        return HttpStatus.OK;
    }

}
