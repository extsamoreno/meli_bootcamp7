package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.response.UserAmountFollowersDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowedListDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowersListDTOres;
import com.bootcamp.socialmeli.exception.FollowYourselfException;
import com.bootcamp.socialmeli.exception.UnfollowYourselfException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IDataRepository;
import com.bootcamp.socialmeli.util.SortUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IDataRepository dataRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SortUtilities sortUtilities;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException, FollowYourselfException {
        //Controlo que los id no sean iguales
        if (userId == userIdToFollow) {
            throw new FollowYourselfException();
        }

        User user = dataRepository.findUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException(userId);
        }

        User userToFollow = dataRepository.findUserById(userIdToFollow);
        if (userToFollow == null) {
            throw new UserIdNotFoundException(userIdToFollow);
        }

        //Agrego el usuario a seguir si éste no se encontraba antes
        if (!user.getFollowed().contains(userIdToFollow)) {
            user.getFollowed().add(userIdToFollow);
        }

        //Agrego
        if (!userToFollow.getFollowers().contains(userId)) {
            userToFollow.getFollowers().add(userId);
        }
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) throws UnfollowYourselfException, UserIdNotFoundException {
        //Controlo que los id no sean iguales
        if (userId == userIdToUnfollow) {
            throw new UnfollowYourselfException();
        }

        User user = dataRepository.findUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException(userId);
        }

        User userToUnfollow = dataRepository.findUserById(userIdToUnfollow);
        if (userToUnfollow == null) {
            throw new UserIdNotFoundException(userIdToUnfollow);
        }

        //Elimino el usuario de la lista de seguidos si es que este ya se encontraba en la misma
        if (user.getFollowed().contains(userIdToUnfollow)) {
            user.getFollowed().removeIf(u -> u == userIdToUnfollow);
        }

        //Elimino el usuario de la lista de seguidores si es que este se encuentra en ella
        if (userToUnfollow.getFollowers().contains(userId)) {
            userToUnfollow.getFollowers().removeIf(u -> u == userId);
        }
    }

    @Override
    public UserAmountFollowersDTOres getAmountUserFollowers(Integer id) throws UserIdNotFoundException {
        User user = dataRepository.findUserById(id);
        if (user == null) {
            throw new UserIdNotFoundException(id);
        }

        return userMapper.toUserAmountFollowersDTO(user);
    }

    @Override
    public UserFollowersListDTOres getListUserFollowers(Integer id, Optional<String> order) throws UserIdNotFoundException {
        List<User> userFollowers = dataRepository.getUserFollowers(id);

        sortUtilities.sortListOfUsers(userFollowers, order);

        return userMapper.toListUserFollowersDTO(dataRepository.findUserById(id), userFollowers);
    }

    @Override
    public UserFollowedListDTOres getListUserFollowed(Integer id, Optional<String> order) throws UserIdNotFoundException {
        List<User> userFollowed = dataRepository.getUserFollowed(id);

        sortUtilities.sortListOfUsers(userFollowed, order);

        return userMapper.toListUserFollowedDTO(dataRepository.findUserById(id), userFollowed);
    }

}
