package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.CountUserFollowersDTO;
import com.spring.desafioSpring.DTOs.FollowedUserDTO;
import com.spring.desafioSpring.DTOs.FollowersUserDTO;
import com.spring.desafioSpring.DTOs.UserIdNameDTO;
import com.spring.desafioSpring.Exceptions.FollowYourselfException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Models.User;
import com.spring.desafioSpring.Repositories.IUserRepository;
import com.spring.desafioSpring.Services.Mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void follow(int userId, int userIdToFollow) throws UserNotFoundException, FollowYourselfException {
        if(userId != userIdToFollow)
            iUserRepository.follow(userId, userIdToFollow);
        else
            throw new FollowYourselfException();
    }

    @Override
    public CountUserFollowersDTO countFollowers(int userId) throws UserNotFoundException {
        User user = iUserRepository.getUser(userId);

        CountUserFollowersDTO dto = new CountUserFollowersDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFollowers_count(user.getFollowers().size());

        return dto;
        //return UserMapper.userToCountUserFollowersDTO(user);
    }

    @Override
    public FollowersUserDTO followersByUser(int userId) throws UserNotFoundException {
        User user = iUserRepository.getUser(userId);

        FollowersUserDTO dto = new FollowersUserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());

        ArrayList<UserIdNameDTO> followers = new ArrayList<>();
        for (User u : user.getFollowers())
            followers.add(UserMapper.userToUserIdNameDTO(u));

        dto.setFollowers(followers);

        return dto;
    }

    @Override
    public FollowedUserDTO followedByUser(int userId) throws UserNotFoundException {
        User user = iUserRepository.getUser(userId);

        FollowedUserDTO dto = new FollowedUserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());

        ArrayList<UserIdNameDTO> followed = new ArrayList<>();
        for (User u : user.getFollowed())
            followed.add(UserMapper.userToUserIdNameDTO(u));

        dto.setFollowed(followed);

        return dto;
    }
}
