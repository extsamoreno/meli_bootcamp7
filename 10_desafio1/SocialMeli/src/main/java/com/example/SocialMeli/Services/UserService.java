package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iUserRepository;
import com.example.SocialMeli.Services.DTOs.FollowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements iUserService{

    @Autowired
    iUserRepository iUserRepository;

    @Override
    public FollowDTO follow(String follower, String followed) throws UserNotFoundException {
        return iUserRepository.follow(follower, followed);
    }
    public List<User> getdb(){
        return iUserRepository.getUsers();
    }
}
