package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.repository.User;
import com.example.demo.socialmeli.repository.UserRepository;
import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public HttpStatus follow(int userid, int useridtofollow) {
        User user = userRepository.getUserId(userid);
        User userFollowed = userRepository.getUserId(useridtofollow);
        user.getFollowed().add(userFollowed.getUserId());
        userRepository.refreshUser(user);
        return HttpStatus.OK;
    }

    @Override
    public CountFollowersDTO countFollowers(int userid) {
        User user = userRepository.getUserId(userid);
        CountFollowersDTO countFollowersDTO = new CountFollowersDTO();
        countFollowersDTO.setUserId(user.getUserId());
        countFollowersDTO.setUserName(user.getUserName());
        countFollowersDTO.setFollowers_count(userRepository.getCountFollowers(userid));
        return countFollowersDTO;
    }

    @Override
    public FollowersListDTO followerList(int userid) {
        User user = userRepository.getUserId(userid);
        FollowersListDTO followersListDTO = new FollowersListDTO();
        followersListDTO.setUserId(userid);
        followersListDTO.setUserName(user.getUserName());
        followersListDTO.setFollowers(userRepository.getFollowersList(userid));
        return followersListDTO;
    }
}
