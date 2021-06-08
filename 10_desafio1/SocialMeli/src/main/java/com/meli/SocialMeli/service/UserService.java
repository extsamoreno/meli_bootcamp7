package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.exception.InvalidUserNameException;
import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.repository.IUserRepository;
import com.meli.SocialMeli.mapper.UserMapper;
import com.meli.SocialMeli.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void newUser(UserNewDto userNewDto) throws InvalidUserNameException {
        validateNewUser(userNewDto);
        User newUser=UserMapper.userNewDtotoUser(userNewDto);
        iUserRepository.newUser(newUser);
    }

    @Override
    public void follow(int followerId, int followedId) throws InvalidUserIdException {
        Follow follow = new Follow(-1, followerId,followedId);
        validateFollow(follow);
        iUserRepository.follow(follow);
    }

    @Override
    public UserFollowerCountDto followerCount(int id) throws InvalidUserIdException {
        validateId(id);
        UserFollowerCountDto userDto = UserMapper.userToUserFollowerCDto(iUserRepository.getUserById(id));
        userDto.setFollowers_count(iUserRepository.getFollowers(id).size());
        return userDto;
    }

    @Override
    public UserFollowerListDto followerList(int id) throws InvalidUserIdException {
        validateId(id);
        UserFollowerListDto userDto = UserMapper.userToUserFollowerLDto(iUserRepository.getUserById(id));
        userDto.setFollowers(UserMapper.batchUserToBasicDto(iUserRepository.getFollowers(id)));
        return userDto;
    }

    @Override
    public UserFollowedListDto followedList(int id) throws InvalidUserIdException {
        validateId(id);
        UserFollowedListDto userDto = UserMapper.userToUserFollowedLDto(iUserRepository.getUserById(id));

        userDto.setFolloweds(UserMapper.batchUserToBasicDto(iUserRepository.getFolloweds(id)));
        return userDto;
    }

    private void validateNewUser(UserNewDto userNewDto) throws InvalidUserNameException {
        if(userNewDto.getUserName().equals("")) throw new InvalidUserNameException();
    }

    private void validateId(int id) throws InvalidUserIdException {
        if(iUserRepository.getUserById(id)==null){
            throw new InvalidUserIdException();
        }
    }

    private void validateFollow(Follow follow) throws InvalidUserIdException {
        if(follow.getFollowerId()== follow.getFollowedId()){
            throw new InvalidUserIdException();
        }
        validateId(follow.getFollowerId());
        validateId(follow.getFollowedId());
    }
}
