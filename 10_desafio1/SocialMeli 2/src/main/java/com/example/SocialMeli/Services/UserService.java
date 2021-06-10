package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Helpers.Ordenable;
import com.example.SocialMeli.Services.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

@org.springframework.stereotype.Service
public class UserService extends Ordenable<UserDTO> implements iUserService{

    @Autowired
    iDataRepository iDataRepository;

    private void addFollowedToUser(User user, int followedId) throws UserNotFoundException {
        List<Integer> following = user.getFollowing();

        if(following.indexOf(followedId) == -1){
            following.add(followedId);
        }

    }
    private void addFollowerToUser(User user, int followerId) throws UserNotFoundException {

        List<Integer> followers = user.getFollowers();

        if(followers.indexOf(followerId) == -1){
            followers.add(followerId);
        }


    }
    private void removeFollowedToUser(User user, int followedId) throws UserNotFoundException {
        List<Integer> following = user.getFollowing();

        int index = following.indexOf(followedId);
        if(index != -1){
            following.remove(index);
        }

    }
    private void removeFollowerToUser(User user, int followerId) throws UserNotFoundException {

        List<Integer> followers = user.getFollowers();

        int index = followers.indexOf(followerId);
        if(index != -1){
            followers.remove(index);
        }

    }
    @Override
    public FollowCountDTO getFollowersCount(int userId) throws UserNotFoundException {

        User user = iDataRepository.getUserByID(userId);

        return new FollowCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }


    @Override
    public FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException {

        User user = iDataRepository.getUserByID(userId);
        List<User> follower = iDataRepository.getUsersByIds(user.getFollowers());
        List<UserDTO> userDTOs = UserMapper.toDTOs(follower);

        this.orderByBubble(userDTOs, this.getComparator(order));

        return new FollowersDTO(user.getId(), user.getName(), userDTOs);
    }

    @Override
    public FollowedDTO getFollowed(int userId, String order) throws UserNotFoundException{

        User user = iDataRepository.getUserByID(userId);
        List<User> followed = iDataRepository.getUsersByIds(user.getFollowing());

        List<UserDTO> userDTOs = UserMapper.toDTOs(followed);
        Comparator<UserDTO> compatator = this.getComparator(order);
        this.orderByBubble(userDTOs, compatator);

        return new FollowedDTO(user.getId(), user.getName(), userDTOs);
    }

    @Override
    public FollowDTO follow(int followerId, int followedId) throws UserNotFoundException {

        User follower = iDataRepository.getUserByID(followerId);
        User followed = iDataRepository.getUserByID(followedId);

        this.addFollowerToUser(followed, followerId);
        this.addFollowedToUser(follower, followedId);

        return new FollowDTO(follower.getId(),followed.getId(), "Follow");
    }

    @Override
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException {
        User follower = iDataRepository.getUserByID(followerId);
        User followed = iDataRepository.getUserByID(followedId);

        this.removeFollowerToUser(followed, followerId);
        this.removeFollowedToUser(follower, followedId);

        return new FollowDTO(follower.getId(),followed.getId(), "Unfollow");
    }

    private Comparator<UserDTO> getComparator(String order){
        Comparator<UserDTO> comparator;

        String orderBy = this.getOrderBy(order);
        String orderType = this.getOrderType(order);

        switch (orderBy){
            case "name": comparator = Comparator.comparing(UserDTO::getUserName);
            case "id": comparator = Comparator.comparing(UserDTO::getUserId);
            default: comparator = Comparator.comparing(UserDTO::getUserName);
        }
        switch (orderType){
            case "desc" : comparator = comparator.reversed();
        }

        return comparator;
    }



    public List<User> getdb(){
        return iDataRepository.getUsers();
    }
}
