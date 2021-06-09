package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.SocialMeli.Services.Service;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public class UserService extends Service implements iUserService{

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

        String orderType = this.getOrderType(order);

        User user = iDataRepository.getUserByID(userId);
        List<User> follower = iDataRepository.getUsersByIds(user.getFollowers());

        List<UserDTO> userDTOs = UserMapper.toDTOs(follower);

        this.orderUsersDTOs(userDTOs, orderType);

        return new FollowersDTO(user.getId(), user.getName(), userDTOs);
    }

    @Override
    public FollowedDTO getFollowed(int userId, String order) throws UserNotFoundException{

        String orderType = this.getOrderType(order);

        User user = iDataRepository.getUserByID(userId);
        List<User> followed = iDataRepository.getUsersByIds(user.getFollowing());

        List<UserDTO> userDTOs = UserMapper.toDTOs(followed);

        this.orderUsersDTOs(userDTOs, orderType);

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

    private void orderUsersDTOs(List<UserDTO> users, String order){

        Boolean condition = (order.equals("asc")) ? true : false;
        for (int i = 0; i < users.size(); i++) {
            for(int j=0;j<users.size()-1;j++)
            {

                if((users.get(j).getUserName().compareTo(users.get(j+1).getUserName()) < 0) == condition)
                {
                    UserDTO aux = new UserDTO(users.get(j).getUserID(),users.get(j).getUserName());
                    users.set(j, users.get(j+1));
                    users.set(j+1, aux);
                }
            }

        }

    }


    public List<User> getdb(){
        return iDataRepository.getUsers();
    }
}
