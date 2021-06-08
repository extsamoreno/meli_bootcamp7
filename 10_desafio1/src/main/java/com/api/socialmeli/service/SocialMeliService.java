package com.api.socialmeli.service;


import com.api.socialmeli.dto.FollowersCountDTO;
import com.api.socialmeli.dto.FollowersDetailDTO;
import org.springframework.stereotype.Service;


@Service
public interface SocialMeliService {
    String US001(Integer userId, Integer userIdToFollow) throws Exception;
    FollowersCountDTO US002(Integer userId) throws Exception;
    FollowersDetailDTO US003(int userId) throws Exception;
}
