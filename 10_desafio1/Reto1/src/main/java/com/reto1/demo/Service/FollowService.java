package com.reto1.demo.Service;

import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.Mapper.UserMapper;
import com.reto1.demo.Model.DTO.UserDTO;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public String followOtherUser(int userId, int userIdToFollow) throws UserIdNotFoundException {
        return iFollowRepository.follow(userId, userIdToFollow);
    }

    @Override
    public UserDTO countFollowers(int userId) throws UserIdNotFoundException {
        return UserMapper.toUserDTO(iFollowRepository.getUserById(userId));
    }
}
