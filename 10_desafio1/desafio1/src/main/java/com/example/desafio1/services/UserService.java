package com.example.desafio1.services;

import com.example.desafio1.dtos.FollowedDTO;
import com.example.desafio1.dtos.FollowersCountDTO;
import com.example.desafio1.dtos.FollowersDTO;
import com.example.desafio1.exceptions.FollowingAlreadyExistsException;
import com.example.desafio1.exceptions.UserIdNotValidException;
import com.example.desafio1.repositories.IUserRepository;
import com.example.desafio1.services.mappers.MeliUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void processNewFollowing(int userId, int userIdToFollow) throws UserIdNotValidException, FollowingAlreadyExistsException {
        //First check both user Ids are valid and exist
        if(iUserRepository.getUserById(userId) == null)
            throw new UserIdNotValidException(userId);
        if(iUserRepository.getUserById(userIdToFollow) == null)
            throw new UserIdNotValidException(userIdToFollow);
        //Then check if the following between these users already exists
        if(iUserRepository.doesFollowingExist(userId,userIdToFollow))
            throw new FollowingAlreadyExistsException();

        iUserRepository.addFollowing(userId,userIdToFollow);
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) {
        FollowersCountDTO follCount = new FollowersCountDTO();
        follCount.setUserId(userId);
        follCount.setUserName(iUserRepository.getUserById(userId).getUserName());
        follCount.setFollowers_count(iUserRepository.getFollowersCount(userId));;

        return follCount;
    }

    @Override
    public FollowersDTO getFollowers(int userId) {
        FollowersDTO followers = new FollowersDTO();
        followers.setUserId(userId);
        followers.setUserName(iUserRepository.getUserById(userId).getUserName());
        followers.setFollowers(MeliUserMapper.toDTOList(iUserRepository.getFollowers(userId)));

        return followers;
    }

    @Override
    public FollowedDTO getFollowed(int userId) {
        FollowedDTO followed = new FollowedDTO();
        followed.setUserId(userId);
        followed.setUserName(iUserRepository.getUserById(userId).getUserName());
        followed.setFollowed(MeliUserMapper.toDTOList(iUserRepository.getFollowed(userId)));

        return followed;
    }
}
