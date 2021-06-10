package com.example.desafio1.services;

import com.example.desafio1.dtos.FollowedDTO;
import com.example.desafio1.dtos.FollowersCountDTO;
import com.example.desafio1.dtos.FollowersDTO;
import com.example.desafio1.exceptions.*;
import com.example.desafio1.repositories.IUserRepository;
import com.example.desafio1.services.mappers.MeliUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void processNewFollowing(int userId, int userIdToFollow) throws UserIdNotValidException, FollowingAlreadyExistsException, RepeatedUsersIdException {
        if(userId == userIdToFollow)
            throw new RepeatedUsersIdException();
        //First check both user Ids are valid and exist
        if (iUserRepository.getUserById(userId) == null)
            throw new UserIdNotValidException(userId);
        if (iUserRepository.getUserById(userIdToFollow) == null)
            throw new UserIdNotValidException(userIdToFollow);
        //Then check if the user A already follows user B
        if (iUserRepository.doesFollowingExist(userId, userIdToFollow))
            throw new FollowingAlreadyExistsException();

        iUserRepository.addFollowing(userId, userIdToFollow);
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) throws OrderNotValidException {
        FollowersCountDTO follCount = new FollowersCountDTO();
        follCount.setUserId(userId);
        follCount.setUserName(iUserRepository.getUserById(userId).getUserName());
        follCount.setFollowersCount(iUserRepository.getFollowers(userId, null).size());

        return follCount;
    }

    @Override
    public FollowersDTO getFollowers(int userId, String order) throws OrderNotValidException {
        FollowersDTO followers = new FollowersDTO();
        followers.setUserId(userId);
        followers.setUserName(iUserRepository.getUserById(userId).getUserName());
        followers.setFollowers(MeliUserMapper.toDTOList(iUserRepository.getFollowers(userId, order)));

        return followers;
    }

    @Override
    public FollowedDTO getFollowed(int userId, String order) throws OrderNotValidException {
        FollowedDTO followed = new FollowedDTO();
        followed.setUserId(userId);
        followed.setUserName(iUserRepository.getUserById(userId).getUserName());
        followed.setFollowed(MeliUserMapper.toDTOList(iUserRepository.getFollowed(userId, order)));

        return followed;
    }

    @Override
    public void processUnfollow(int userId, int userIdToUnfollow) throws UserIdNotValidException, FollowingDoesNotExistException {
        //First check both user Ids are valid and exist
        if (iUserRepository.getUserById(userId) == null)
            throw new UserIdNotValidException(userId);
        if (iUserRepository.getUserById(userIdToUnfollow) == null)
            throw new UserIdNotValidException(userIdToUnfollow);
        //Then check if the user A already follows user B
        if (!iUserRepository.doesFollowingExist(userId, userIdToUnfollow))
            throw new FollowingDoesNotExistException();

        iUserRepository.removeFollowing(userId, userIdToUnfollow);
    }
}
