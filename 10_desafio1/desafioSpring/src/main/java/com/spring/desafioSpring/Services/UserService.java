package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.*;
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
    public void unfollow(int userId, int userIdToUnollow) throws UserNotFoundException {
        iUserRepository.unfollow(userId, userIdToUnollow);
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
    public FollowersUserDTO followersByUser(int userId, String order) throws UserNotFoundException {
        User user = iUserRepository.getUser(userId);

        FollowersUserDTO dto = new FollowersUserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());

        ArrayList<UserIdNameDTO> followers = new ArrayList<>();

        for (User u : user.getFollowers())
            followers.add(UserMapper.userToUserIdNameDTO(u));

        if(order != null)
            orderListUserIdNameDTObyName(followers, order);

        dto.setFollowers(followers);

        return dto;
    }

    @Override
    public FollowedUserDTO followedByUser(int userId, String order) throws UserNotFoundException {
        User user = iUserRepository.getUser(userId);

        FollowedUserDTO dto = new FollowedUserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());

        ArrayList<UserIdNameDTO> followed = new ArrayList<>();
        for (User u : user.getFollowed())
            followed.add(UserMapper.userToUserIdNameDTO(u));

        if(order != null)
            orderListUserIdNameDTObyName(followed, order);

        dto.setFollowed(followed);

        return dto;
    }

    @Override
    public UserDTO getUserById(int userId) throws UserNotFoundException {
        return UserMapper.userToUserDTO(iUserRepository.getUser(userId));
    }

    private void orderListUserIdNameDTObyName(ArrayList<UserIdNameDTO> list, String order) {
        switch (order){
            case ("name_asc") :
                list.sort( (a,b) -> a.getUserName().compareTo(b.getUserName()));
            break;

            case ("name_desc") :
                list.sort( (a,b) -> b.getUserName().compareTo(a.getUserName()));
            break;

            default:
        }
    }

}
