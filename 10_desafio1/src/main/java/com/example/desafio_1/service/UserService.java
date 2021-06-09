package com.example.desafio_1.service;

import com.example.desafio_1.exception.UserExceptionAlreadyFollowed;
import com.example.desafio_1.exception.UserExceptionNotFound;
import com.example.desafio_1.exception.UserExceptionWrongType;
import com.example.desafio_1.models.Buyer;
import com.example.desafio_1.models.Seller;
import com.example.desafio_1.models.User;
import com.example.desafio_1.repository.IUserRepository;
import com.example.desafio_1.service.dto.UserDTO;
import com.example.desafio_1.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserExceptionNotFound, UserExceptionWrongType, UserExceptionAlreadyFollowed {

        //Existence validated in those method
        User userFollower = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);

        //Check instances
        checkInstance(userFollower, "buyer");
        checkInstance(userToFollow, "seller");

        checkAlreadyFollows((Buyer) userFollower, userIdToFollow);

        userRepository.followUser((Buyer) userFollower, (Seller) userToFollow);
    }

    private void checkAlreadyFollows(Buyer userFollower , int userIdToFollow) throws UserExceptionAlreadyFollowed {
        //Validate that the user is not in the list
        if (userFollower.getFollowing().get(userIdToFollow) != null) {
            throw new UserExceptionAlreadyFollowed(userFollower.getId(), userIdToFollow);
        }
    }

    @Override
    public void checkInstance(User user, String instanceType) throws UserExceptionWrongType {
        if (instanceType.equals("buyer") && !(user instanceof Buyer)) {
            throw new UserExceptionWrongType(user.getId(), "Buyer");
        }
        if (instanceType.equals("seller") && !(user instanceof Seller)) {
            throw new UserExceptionWrongType(user.getId(), "Seller");
        }
    }

    @Override
    public void checkInstance(int userId, String instanceType) throws UserExceptionWrongType, UserExceptionNotFound {
        checkInstance(getUserById(userId), instanceType);
    }

    @Override
    public UserDTO getFollowersCount(int userId) throws UserExceptionNotFound, UserExceptionWrongType {

        User user = getUserById(userId);

        checkInstance(user, "seller");

        UserDTO userDTO = userMapper.toDto(user);

        userDTO.setFollowers_count(((Seller) user).getFollowers().size());

        return userDTO;
    }

    @Override
    public UserDTO getFollowersList(int userId) throws UserExceptionWrongType, UserExceptionNotFound {
        User user = getUserById(userId);

        checkInstance(user, "seller");

        UserDTO userDTO = userMapper.toDto(user);
        //Maybe extract to method

        Collection<Buyer> followers = ((Seller) user).getFollowers().values();

        List<UserDTO> followerListDTO = followers.stream().map(x -> userMapper.toDto(x)).collect(Collectors.toList());

        userDTO.setFollowers(followerListDTO);

        return userDTO;
    }

    //Medio duplicado esto
    @Override
    public UserDTO getFollowingList(int userId) throws UserExceptionWrongType, UserExceptionNotFound {
        User user = getUserById(userId);

        checkInstance(user, "buyer");

        UserDTO userDTO = userMapper.toDto(user);
        //Maybe extract to method

        Collection<Seller> following = ((Buyer) user).getFollowing().values();

        List<UserDTO> followingListDTO = following.stream().map(x -> userMapper.toDto(x)).collect(Collectors.toList());

        userDTO.setFollowing(followingListDTO);

        return userDTO;
    }

    @Override
    public boolean existsUser(int userId) throws UserExceptionNotFound {
        if(userRepository.getById(userId) == null) {
            throw new UserExceptionNotFound(userId);
        }
        return true;
    }

    private User getUserById(int userId) throws UserExceptionNotFound {

        User user = userRepository.getById(userId);

        if (user == null) {
            throw new UserExceptionNotFound(userId);
        }

        return user;
    }

}
