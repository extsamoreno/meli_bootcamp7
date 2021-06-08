package com.desafiospring.socialMeli.service;


import com.desafiospring.socialMeli.dto.FollowersCountDTO;
import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.dto.UserFollowedDTO;
import com.desafiospring.socialMeli.dto.UserFollowingDTO;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.User;
import com.desafiospring.socialMeli.repository.ISocialMeliRepository;

import com.desafiospring.socialMeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    ISocialMeliRepository socialMeliRepository;

    @Override
    public void followSeller(int userId, int userIdToFollow) throws UserNotFoundException {
        socialMeliRepository.findUserById(userId);
        socialMeliRepository.findUserById(userIdToFollow);
        socialMeliRepository.addFollowerToUser(userId, userIdToFollow);
    }

    @Override
    public FollowersCountDTO getNumberOfFollowers(int userId) throws UserNotFoundException {
        User user = socialMeliRepository.findUserById(userId);
        int count = socialMeliRepository.getFollowersCount(userId);

        FollowersCountDTO response = new FollowersCountDTO();
        response.setUserId(userId);
        response.setUserName(user.getUserName());
        response.setFollowers_count(count);
        return response;
    }

    @Override
    public UserFollowingDTO getFollowingList(int userId) throws UserNotFoundException {
        //UserDTO user = SocialMeliMapper.toDto(socialMeliRepository.findUserById(userId));
        User user = socialMeliRepository.findUserById(userId);
        List<UserDTO> followingList = new ArrayList<>();

        for (User u : user.getFollowers()) {
            followingList.add(UserMapper.toDto(u));
        }

        return new UserFollowingDTO(user.getUserId(),user.getUserName(),followingList);
    }

    @Override
    public UserFollowedDTO getFollowers(int userId) throws UserNotFoundException {
        User user = socialMeliRepository.findUserById(userId);
        List<UserDTO> followingList = new ArrayList<>();
        for (User u : user.getFollowedBy()) {
            followingList.add(UserMapper.toDto(u));
        }

        return new UserFollowedDTO(user.getUserId(),user.getUserName(),followingList);
    }

}
