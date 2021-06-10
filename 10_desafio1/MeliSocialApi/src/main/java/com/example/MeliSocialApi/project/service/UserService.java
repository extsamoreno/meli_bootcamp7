package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.Utils.Constant;
import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.exception.UsersMustBeDifferentException;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.repository.IUserRepository;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;
import com.example.MeliSocialApi.project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    public boolean follow(Integer idUser, Integer idUserToFollow) throws UserNotFoundException, UsersMustBeDifferentException {
        if(idUser.equals(idUserToFollow))
            throw new UsersMustBeDifferentException();
        addFollowing(getUser(idUser),getUser(idUserToFollow));
        addFollower(getUser(idUserToFollow),getUser(idUser));
        return true;
    }
    @Override
    public boolean unfollow(Integer idUser, Integer idUserToUnfollow) throws UserNotFoundException, UsersMustBeDifferentException {
        if(idUser.equals(idUserToUnfollow))
            throw new UsersMustBeDifferentException();
        removeFollowing(getUser(idUser),getUser(idUserToUnfollow));
        removeFollower(getUser(idUserToUnfollow),getUser(idUser));
        return true;
    }
    @Override
    public UserFollowersCountDTOResponse getFollowersCount(Integer idUser) throws UserNotFoundException {
        User user = getUser(idUser);
        return UserMapper.userToUserFollowersCountDTO(user);
    }
    public User getUser(Integer id) throws UserNotFoundException {
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
        orderAlphabetically(followersUser,order);
        return UserMapper.userToFollowersUserDTO(user,followersUser);
    }
    @Override
    public FollowersUserDTOResponse getFollowedList(Integer idUser, Optional<String> order) throws UserNotFoundException {
        User user = getUser(idUser);
        LinkedHashSet<Integer> followings = user.getFollowing();
        LinkedList<User> followingsUser = new LinkedList<User>();
        for(Integer following : followings){
            followingsUser.add(getUser(following));
        }
        orderAlphabetically(followingsUser,order);
        return UserMapper.userToFollowersUserDTO(user,followingsUser);

    }
    private void orderAlphabetically(LinkedList<User> users, Optional<String> order){
        Comparator<User> userNameComparator = Comparator.comparing(u -> u.getName().toLowerCase());
        Optional<Optional<String>> orderNoNullable = Optional.ofNullable(order).filter(s -> !s.isEmpty());
        if(order.isPresent()) {
            switch (order.get()) {
                case Constant.OrderAlphabeticallyUp:
                    users.sort(userNameComparator);
                    break;
                case Constant.OrderAlphabeticallyBack:
                    users.sort(userNameComparator.reversed());
                    break;
            }
        }
    }
    private void addFollower(User userToFollow, User user){
        userToFollow.getFollowers().add(user.getId());
    }
    private void addFollowing(User user, User userToFollowing){
        user.getFollowing().add(userToFollowing.getId());
    }
    private void removeFollower(User user, User userToUnfollower){
        user.getFollowers().remove(userToUnfollower.getId());
    }
    private void removeFollowing(User user, User userToUnfollowing){
        user.getFollowing().remove(userToUnfollowing.getId());
    }

}
