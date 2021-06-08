package com.api.socialmeli.service;


import com.api.socialmeli.dto.FollowersCountDTO;
import org.springframework.stereotype.Service;

@Service
public interface SocialMeliService {
    String US001(Integer userId, Integer userIdToFollow);
    FollowersCountDTO US002(Integer userId);
}
