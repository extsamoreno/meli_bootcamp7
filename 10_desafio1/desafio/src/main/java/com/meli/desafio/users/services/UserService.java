package com.meli.desafio.users.services;

import com.meli.desafio.users.exceptions.UserAlredyFollowedException;
import com.meli.desafio.users.exceptions.UserFollowYourselfException;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.mappers.UserMapper;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.users.models.dto.ResponseUserListFollowed;
import com.meli.desafio.users.models.dto.ResponseUserListFollowers;
import com.meli.desafio.users.models.dto.UserDTO;
import com.meli.desafio.users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void addNewFollow(Integer userId, Integer userIdToFollow)
            throws UserNotFoundException, UserFollowYourselfException, UserAlredyFollowedException {
        if(userId == userIdToFollow) throw new UserFollowYourselfException();

        User userFollower = userRepository.getById(userId);
        if(userFollower.getFollowed().contains(userIdToFollow)) throw new UserAlredyFollowedException();

        userFollower.getFollowed().add(userIdToFollow);
    }

    @Override
    public ResponseUserCountFollowers showCountFollowers(Integer userId) throws UserNotFoundException {
        User user = userRepository.getById(userId);

        ResponseUserCountFollowers response = UserMapper.userToResponse(user);
        response.setFollowersCount(userRepository.getFollowersTo(user).size());

        return response;
    }

    @Override
    public ResponseUserListFollowers showAllFollowers(Integer userId, String order) throws UserNotFoundException {
        User user = userRepository.getById(userId);
        ResponseUserListFollowers userDTO = UserMapper.userToResponseList(user);
        List<Integer> listFollowersIds = userRepository.getFollowersTo(user);
        List<UserDTO> listUsersDTO = new ArrayList<>();

        for(Integer id: listFollowersIds){
            listUsersDTO.add(UserMapper.userToDTO(userRepository.getById(id)));
        }
        userDTO.setFollowersList(listUsersDTO);

        Collections.sort(userDTO.getFollowersList());
        if(order.equalsIgnoreCase("name_desc"))
                Collections.reverse(userDTO.getFollowersList());

        return userDTO;
    }

    @Override
    public ResponseUserListFollowed showAllFollowed(Integer userId, String order) throws UserNotFoundException {
        User user = userRepository.getById(userId);

        List<UserDTO> listUserDTo = new ArrayList<>();
        for(Integer id: user.getFollowed()){
            UserDTO userDTO = UserMapper.userToDTO(userRepository.getById(id));
            listUserDTo.add(userDTO);
        }

        Collections.sort(listUserDTo);
        if(order.equalsIgnoreCase("name_desc"))
            Collections.reverse(listUserDTo);

        return UserMapper.userToUserWithFollowed(user, listUserDTo);
    }

    @Override
    public boolean userExist(Integer userId) {
        return userRepository.userExist(userId);
    }

    @Override
    public User getById(Integer userId) throws UserNotFoundException {
        return userRepository.getById(userId);
    }

    @Override
    public void removeFollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException {
        userRepository.removeFollow(userId, userIdToUnfollow);
    }
}
