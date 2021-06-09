package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.repositories.IUserRepository;
import com.example.DesafioSpring.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class UserByServiceImple extends OrderByService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

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
    public FollowersCountDTO getFollowersCount(int userId) throws UserNotFoundException {

        User user = iUserRepository.getUserByID(userId);

        return new FollowersCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }


    @Override
    public FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException {

        String orderType = this.getOrderType(order);

        User user = iUserRepository.getUserByID(userId);
        List<User> follower = iUserRepository.getUsersByIds(user.getFollowers());

        List<UserDTO> userDTOs = UserMapper.toDTOs(follower);

        this.orderUsersDTOs(userDTOs, orderType);

        return new FollowersDTO(user.getId(), user.getName(), userDTOs);
    }

    @Override
    public FollowedByDTO getFollowed(int userId, String order) throws UserNotFoundException{

        String orderType = this.getOrderType(order);

        User user = iUserRepository.getUserByID(userId);
        List<User> followed = iUserRepository.getUsersByIds(user.getFollowing());

        List<UserDTO> userDTOs = UserMapper.toDTOs(followed);

        this.orderUsersDTOs(userDTOs, orderType);

        return new FollowedByDTO(user.getId(), user.getName(), userDTOs);
    }
    public List<User> getUserDatabase(){
        return iUserRepository.getUsers();
    }
    @Override
    public FollowDTO followSeller(int followerId, int followedId) throws UserNotFoundException {

        User follower = iUserRepository.getUserByID(followerId);
        User followed = iUserRepository.getUserByID(followedId);

        this.addFollowerToUser(followed, followerId);
        this.addFollowedToUser(follower, followedId);

        return new FollowDTO(follower.getId(),followed.getId(), "Follow");
    }

    @Override
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException {
        User follower = iUserRepository.getUserByID(followerId);
        User followed = iUserRepository.getUserByID(followedId);

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
                    UserDTO aux = new UserDTO(users.get(j).getUserId(),users.get(j).getUserName());
                    users.set(j, users.get(j+1));
                    users.set(j+1, aux);
                }
            }

        }

    }

}
