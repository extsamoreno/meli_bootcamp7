package com.example.socialmeli.service;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.exceptions.UserFollowthisUserException;
import com.example.socialmeli.exceptions.UserIdNotFountException;
import com.example.socialmeli.mapper.UserMapper;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {
    IUserRepository iUserRepository;
    UserMapper userMapper;

    public UserService(IUserRepository iUserRepository, UserMapper userMapper) {
        this.iUserRepository = iUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO userAdd(UserDTO dto) {
        return userMapper.toUserDTO(iUserRepository.userAdd(userMapper.toUser(dto)));
    }

    @Override
    public UserDTO getUserById(int userId) {
        return userMapper.toUserDTO(iUserRepository.getUserById(userId));
    }

    @Override
    public List<UserDTO> userAddList(List<UserDTO> dto) {
        List<UserDTO> response = new ArrayList<>();
        for (UserDTO obj : dto) {
            response.add(userMapper.toUserDTO(iUserRepository.userAdd(userMapper.toUser(obj))));
        }
        return response;
    }

    @Override
    public boolean userFollow(int userid, int useridFollow) throws UserFollowthisUserException{
        if(userid==useridFollow){
            throw new UserFollowthisUserException(userid);
        }
        return iUserRepository.userFollow(userid, useridFollow);
    }

    @Override
    public UserFolCouResponseDTO getFollowersCount(int userId) throws UserIdNotFountException {
        User user = iUserRepository.getUserById(userId);
        if(user==null){
            throw new UserIdNotFountException(userId);
        }
        return new UserFolCouResponseDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public UserFolsLisResponseDTO getFollowersList(int userId, String order) throws UserIdNotFountException {
        User user = iUserRepository.getUserById(userId);
        if(user==null){
            throw new UserIdNotFountException(userId);
        }
        List<UserDTO> followers = new ArrayList<>();
        for (User obj : user.getFollowers()) {
            followers.add(userMapper.toUserDTO(obj));
        }
        if (order != null) {
            if (order.equals("name_asc")) {
                followers.sort(Comparator.comparing(UserDTO::getUserName));
            }
            if (order.equals("name_desc")) {
                followers.sort(Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        return new UserFolsLisResponseDTO(user.getUserId(), user.getUserName(), followers);
    }

    @Override
    public UserFolLisResponseDTO getFollowedList(int userId, String order) throws UserIdNotFountException {
        User user= iUserRepository.getUserById(userId);
        if(user==null){
            throw new UserIdNotFountException(userId);
        }
        List<UserDTO> followed = new ArrayList<>();
        for (User obj : user.getFollowed()) {
            followed.add(userMapper.toUserDTO(obj));
        }
        if (order != null) {
            if (order.equals("name_asc")) {
                followed.sort(Comparator.comparing(UserDTO::getUserName));
            }
            if (order.equals("name_desc")) {
                followed.sort(Comparator.comparing(UserDTO::getUserName).reversed());
            }
        }
        return new UserFolLisResponseDTO(user.getUserId(), user.getUserName(), followed);
    }

    @Override
    public boolean userUnFollow(int userid, int useridFollow) throws UserFollowthisUserException {
        if(userid==useridFollow){
            throw new UserFollowthisUserException(userid);
        }
        return iUserRepository.userUnFollow(userid, useridFollow);
    }
}
