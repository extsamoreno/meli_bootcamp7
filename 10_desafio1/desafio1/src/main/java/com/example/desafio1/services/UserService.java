package com.example.desafio1.services;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.mappers.UserMapper;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;
import com.example.desafio1.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public String createDB() {
        return iUserRepository.createDB();
    }

    @Override
    public User getUserById(int userId) throws InvalidUserIdException {
        return iUserRepository.getUserById(userId);
    }

    @Override
    public String followUser(int userId, int userIdToFollow) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        User userToFollow = iUserRepository.getUserById(userIdToFollow);
        user.addFollowed(UserMapper.UserToDTO(userToFollow));
        userToFollow.addFollower(UserMapper.UserToDTO(user));
        return userId + " ha seguido a " + userIdToFollow;
    }

    @Override
    public String unfollowUser(int userId, int userIdToUnfollow) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        User userToUnfollow = iUserRepository.getUserById(userIdToUnfollow);
        user.removeFollowed(UserMapper.UserToDTO(userToUnfollow));
        userToUnfollow.removeFollower(UserMapper.UserToDTO(user));
        return userId + " ha dejado de seguido a " + userIdToUnfollow;
    }

    @Override
    public ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowerCountDTO responseFollowerCountDTO = new ResponseFollowerCountDTO();
        responseFollowerCountDTO.setUserId(user.getUserId());
        responseFollowerCountDTO.setUserName(user.getUserName());
        responseFollowerCountDTO.setFollowers_count(user.getFollowers().size());
        return responseFollowerCountDTO;
    }

    @Override
    public ResponseFollowerListDTO getFollowers(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowerListDTO responseFollowerListDTO = new ResponseFollowerListDTO();
        responseFollowerListDTO.setUserId(user.getUserId());
        responseFollowerListDTO.setUserName(user.getUserName());
        responseFollowerListDTO.setFollowers(user.getFollowers());
        return responseFollowerListDTO;
    }

    @Override
    public ResponseFollowedSellerDTO getFollowedSellers(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowedSellerDTO responseFollowedSellerDTO = new ResponseFollowedSellerDTO();
        responseFollowedSellerDTO.setUserId(user.getUserId());
        responseFollowedSellerDTO.setUserName(user.getUserName());
        responseFollowedSellerDTO.setFollowed(user.getFollowed());
        return responseFollowedSellerDTO;
    }

    @Override
    public List<UserDTO> getFollowedList(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        return user.getFollowed();
    }

    @Override
    public List<Post> getPostsList(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        return user.getPosts();
    }
}
