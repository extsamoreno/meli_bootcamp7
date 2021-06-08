package com.api.socialmeli.service;


import com.api.socialmeli.dto.FollowersCountDTO;
import com.api.socialmeli.dto.FollowersDetailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface SocialMeliService {
    String US001(Integer userId, Integer userIdToFollow);
    FollowersCountDTO US002(Integer userId);
    FollowersDetailDTO US003(int userId);
}
