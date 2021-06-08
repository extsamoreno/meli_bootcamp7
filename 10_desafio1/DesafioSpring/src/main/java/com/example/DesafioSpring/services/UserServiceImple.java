package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.FollowDTO;
import com.example.DesafioSpring.dto.FollowersCountDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements IuserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public FollowDTO followSeller(String follower, String followed) throws UserNotFoundException {
        return iUserRepository.followSeller(follower, followed);
    }

    @Override
    public FollowersCountDTO getFollowersCount(String userId) throws UserNotFoundException {
        return iUserRepository.getFollowersCount(userId);

    }

    public List<User> getDatabase(){
        return iUserRepository.getUsers();
    }
}
