package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.Utils.Constant;
import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.repository.IUserRepository;
import com.example.MeliSocialApi.project.service.dto.FollowedUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;
import com.example.MeliSocialApi.project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    public boolean follow(Integer idUser, Integer idUserToFollow) throws UserNotFoundException{
        getUser(idUser).addFollowing(idUserToFollow);
        getUser(idUserToFollow).addFollower(idUser);
        return true;
    }

    @Override
    public boolean unfollow(Integer idUser, Integer idUserToUnfollow) throws UserNotFoundException {
        getUser(idUser).unfollowing(idUserToUnfollow);
        getUser(idUserToUnfollow).unfollower(idUser);
        return true;
    }

    @Override
    public UserFollowersCountDTOResponse getFollowersCount(Integer idUser) throws UserNotFoundException {
        User user = getUser(idUser);
        return UserMapper.userToUserFollowersCountDTO(user);
    }
    /*
    @Override
    public FollowersUserDTOResponse getFollowersList(Integer idUser) throws UserNotFoundException {
        User user = getUser(idUser);
        LinkedHashSet<Integer> followers = user.getFollowers();
        LinkedHashSet<User> followersUser = new LinkedHashSet<User>();
        for(Integer follower : followers){
            followersUser.add(userRepository.getUser(follower));
        }
        return UserMapper.userToFollowersUserDTO(user,followersUser);
    }

    @Override
    public FollowedUserDTOResponse getFollowedList(Integer idUser) throws UserNotFoundException {
        User user = getUser(idUser);
        LinkedHashSet<Integer> followers = user.getFollowers();
        LinkedHashSet<User> followedUsers = new LinkedHashSet<User>();
        for(Integer follower : followers){
            followedUsers.add(userRepository.getUser(follower));
        }
        return UserMapper.userToFollowedUserDTO(user,followedUsers);
    }*/
    private User getUser(Integer id) throws UserNotFoundException {
        User user = userRepository.getUser(id);
        if(user==null)
            throw new UserNotFoundException(id);
        return user;
    }

    @Override
    public FollowersUserDTOResponse getFollowersList(Integer idUser, Optional<String> order) throws UserNotFoundException {
        User user = getUser(idUser);
        LinkedHashSet<Integer> followers = user.getFollowers();
        LinkedList<User> followersUser = new LinkedList<>();
        for(Integer follower : followers){
            followersUser.add(getUser(follower));
        }
        Comparator<User> userNameComparator = Comparator.comparing(u -> u.getName().toLowerCase());
        Optional<Optional<String>> orderNoNullable = Optional.ofNullable(order).filter(s -> !s.isEmpty());
        if(order.isPresent()) {
            switch (order.get()) {
                case Constant.OrderAlphabeticallyUp:
                    followersUser.sort(userNameComparator);
                    break;
                case Constant.OrderAlphabeticallyBack:
                    followersUser.sort(userNameComparator.reversed());
                    break;
            }
        }
        return UserMapper.userToFollowersUserDTO(user,followersUser);
    }
    @Override
    public FollowersUserDTOResponse getFollowedList(Integer idUser, Optional<String> order) throws UserNotFoundException {
        User user = getUser(idUser);
        LinkedHashSet<Integer> followings = user.getFollowing();
        LinkedList<User> followingsUser = new LinkedList<User>();
        for(Integer following : followings){
            followingsUser.add(userRepository.getUser(following));
        }
        Comparator<User> userNameComparator = Comparator.comparing(u -> u.getName().toLowerCase());
        if(order.isPresent()) {
            switch (order.get()) {
                case Constant.OrderAlphabeticallyUp:
                    followingsUser.sort(userNameComparator);
                    break;
                case Constant.OrderAlphabeticallyBack:
                    followingsUser.sort(userNameComparator.reversed());
                    break;
            }
        }
        return UserMapper.userToFollowersUserDTO(user,followingsUser);

    }

}
