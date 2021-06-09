package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.UserNotFoundException;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

@org.springframework.stereotype.Service
public class UserService implements iUserService{

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

        Comparator<UserDTO> compatator = this.getComparator(order);
        this.orderUsersDTOs(userDTOs, compatator);

        return new FollowersDTO(user.getId(), user.getName(), userDTOs);
    }

    @Override
    public FollowedDTO getFollowed(int userId, String order) throws UserNotFoundException{



        User user = iDataRepository.getUserByID(userId);
        List<User> followed = iDataRepository.getUsersByIds(user.getFollowing());

        List<UserDTO> userDTOs = UserMapper.toDTOs(followed);
        Comparator<UserDTO> compatator = this.getComparator(order);
        this.orderUsersDTOs(userDTOs, compatator);

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
    String getOrderType(String order){
        String standarOrder = "desc";
        if(order != null){
            String[] orderArray = order.split("_");
            String orderType = (orderArray.length == 2) ? orderArray[1] : standarOrder;

            return orderType;
        }
        else{
            return standarOrder;
        }

    }
    String getOrderBy(String order){
        String standarOrder = "desc";
        if(order != null){
            String[] orderArray = order.split("_");
            String orderType = (orderArray.length == 2) ? orderArray[1] : standarOrder;

            return orderType;
        }
        else{
            return standarOrder;
        }

    }
    private Comparator<UserDTO> getComparator(String order){
        Comparator<UserDTO> comparator;
        String orderBy = this.getOrderBy(order);
        String orderType = this.getOrderBy(order);

        switch (orderBy){
            case "name": comparator = Comparator.comparing(UserDTO::getUserName);
            default: comparator = Comparator.comparing(UserDTO::getUserName);

        }

        switch (orderType){
            case "desc" : comparator = comparator.reversed();


        }

        return comparator;

    }
    private void orderUsersDTOs(List<UserDTO> users, Comparator<UserDTO> comparator){
        System.out.println(users.get(0).getUserName());
        System.out.println(users.get(1).getUserName());
        System.out.println(comparator.compare(users.get(0),users.get(1)));
        comparator = comparator.reversed();

        System.out.println(comparator.compare(users.get(0),users.get(1)));

        for (int i = 0; i < users.size(); i++) {
            for(int j=0;j<users.size()-1;j++)
            {

                if(comparator.compare(users.get(j+1),users.get(j)) > 0)
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
