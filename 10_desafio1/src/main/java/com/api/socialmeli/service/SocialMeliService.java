package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface SocialMeliService {
    String US001(Integer userId, Integer userIdToFollow) throws Exception;
    FollowersCountDTO US002(Integer userId) throws Exception;
    FollowersDTO US003(int userId, String order) throws Exception;
    UserFolowedDTO US004(int userId, String order) throws Exception;
    String US005(PostDTO newPost ) throws Exception;
    FollowedPostsDTO US006(int userId , String order) throws Exception;
    String US007(int userId, int userIdToUnfollow) throws Exception;
    CountPromoDTO US011(int userId) throws Exception;
    PostPromoDTO US012(int userId) throws Exception;
}
