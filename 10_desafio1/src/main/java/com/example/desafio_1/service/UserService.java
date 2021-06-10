package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.models.Buyer;
import com.example.desafio_1.models.Seller;
import com.example.desafio_1.models.User;
import com.example.desafio_1.repository.IUserRepository;
import com.example.desafio_1.service.dto.FollowedListDTO;
import com.example.desafio_1.service.dto.FollowerCountDTO;
import com.example.desafio_1.service.dto.FollowerListDTO;
import com.example.desafio_1.service.dto.UserDTO;
import com.example.desafio_1.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
    public FollowerCountDTO getFollowersCount(int userId) throws UserExceptionNotFound, UserExceptionWrongType {

        User user = getUserById(userId);

        checkInstance(user, "seller");

        return new FollowerCountDTO(user.getId(), user.getName(), ((Seller) user).getFollowers().size());
    }

    @Override
    public FollowerListDTO getFollowersList(int userId, String order) throws UserExceptionWrongType, UserExceptionNotFound, WrongOrderFieldException {
        User user = getUserById(userId);

        checkInstance(user, "seller");

        Collection<Buyer> followers = ((Seller) user).getFollowers().values();

        List<UserDTO> followerListDTO = followers.stream().map(x -> userMapper.toDto(x)).collect(Collectors.toList());

        if(!order.isEmpty()) {
            orderListOfUser(followerListDTO, order);
        }

        return new FollowerListDTO(userId, user.getName(), followerListDTO);
    }

    //Medio duplicado esto
    @Override
    public FollowedListDTO getFollowingList(int userId, String order) throws UserExceptionWrongType, UserExceptionNotFound, WrongOrderFieldException {
        User user = getUserById(userId);

        checkInstance(user, "buyer");

        Collection<Seller> following = ((Buyer) user).getFollowing().values();

        List<UserDTO> followingListDTO = following.stream().map(x -> userMapper.toDto(x)).collect(Collectors.toList());

        if(!order.isEmpty()) {
            orderListOfUser(followingListDTO, order);
        }

        return new FollowedListDTO(userId, user.getName(), followingListDTO);
    }

    private void orderListOfUser(List<UserDTO> followingListDTO, String order) throws WrongOrderFieldException {
        if(order.equalsIgnoreCase("name_asc")) {
            followingListDTO.sort(Comparator.comparing(UserDTO::getUserName));
            return;
        }
        if(order.equalsIgnoreCase("name_desc")) {
            followingListDTO.sort(Collections.reverseOrder(Comparator.comparing(UserDTO::getUserName)));
            return;
        }
        if(!order.isEmpty()) { //if is not empty and the order criteria is not valid...
            throw new WrongOrderFieldException(order);
        }
    }

    @Override
    public boolean existsUser(int userId) throws UserExceptionNotFound {
        if(userRepository.getById(userId) == null) {
            throw new UserExceptionNotFound(userId);
        }
        return true;
    }

    @Override
    public User getUserById(int userId) throws UserExceptionNotFound {

        User user = userRepository.getById(userId);

        if (user == null) {
            throw new UserExceptionNotFound(userId);
        }

        return user;
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnFollow) throws UserExceptionNotFound, UserExceptionWrongType, UserExceptionNotFollowing {
        //Existence validated in those method
        User userFollower = getUserById(userId);
        User userToFollow = getUserById(userIdToUnFollow);

        //Check instances
        checkInstance(userFollower, "buyer");
        checkInstance(userToFollow, "seller");

        checkNotFollowing((Buyer) userFollower, userIdToUnFollow);

        userRepository.unfollowUser((Buyer) userFollower, (Seller) userToFollow);
    }

    private void checkNotFollowing(Buyer userFollower , int userIdToCheck) throws UserExceptionNotFollowing {
        //Validate that the user is not in the list
        if (userFollower.getFollowing().get(userIdToCheck) == null) {
            throw new UserExceptionNotFollowing(userFollower.getId(), userIdToCheck);
        }
    }

}
