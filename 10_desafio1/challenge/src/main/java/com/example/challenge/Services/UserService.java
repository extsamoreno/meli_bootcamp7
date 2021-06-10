package com.example.challenge.Services;

import com.example.challenge.Exceptions.*;
import com.example.challenge.Models.User;
import com.example.challenge.Repositories.IUserRepository;
import com.example.challenge.Services.DTOs.*;
import com.example.challenge.Services.Mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final Comparator<User> COMPARATOR_NAME_ASC = Comparator.comparing(User::getName);
    private final Comparator<User> COMPARATOR_NAME_DES = (a, b) -> b.getName().compareTo(a.getName());

    IUserRepository iUserRepository;

    UserMapper um = new UserMapper();

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public String loadUser() throws UserNotFoundException, PostDuplicateException {
        iUserRepository.loadData();
        return "Data load";
    }

    @Override
    public FollowDTO followUser(int follower, int followed) throws UserNotFoundException, UserSameIdException, UserAlreadyFollowException {

        if (followed == follower) {
            throw new UserSameIdException();
        }
        User userFollower = iUserRepository.findUserById(follower);
        User userFollowed = iUserRepository.findUserById(followed);
        if (userFollower.getFollowed().contains(userFollowed)) {
            throw new UserAlreadyFollowException(follower, followed);
        }
        return iUserRepository.follow(follower, followed);
    }

    public List<GetUserDTO> getUsers() {
        List<GetUserDTO> res = new ArrayList<>();
        for (User u : iUserRepository.getUsers()) {
            res.add(um.userToGetUser(u));
        }
        return res;
    }

    @Override
    public FollowerCountDTO getFollowersCount(int userId) throws UserNotFoundException {
        User u = iUserRepository.findUserById(userId);
        return um.userToFollowerCount(u);
    }

    @Override
    public FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException, InvalidOrderException {
        User u = iUserRepository.findUserById(userId);
        sortUserDTOByName(order, u.getFollowers());
        return um.userToFollowers(u);
    }

    @Override
    public FollowersDTO getFollowed(int userId, String order) throws UserNotFoundException, InvalidOrderException {
        User u = iUserRepository.findUserById(userId);
        sortUserDTOByName(order, u.getFollowed());
        return um.userToFollowed(u);
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        return iUserRepository.findUserById(userId);
    }


    @Override
    public FollowDTO unfollowUser(int follower, int followed) throws UserNotFoundException, UserSameIdException, UserNotFollowException {

        if (followed == follower) {
            throw new UserSameIdException();
        }
        User userFollower = iUserRepository.findUserById(follower);
        User userFollowed = iUserRepository.findUserById(followed);
        if (!userFollower.getFollowed().contains(userFollowed))
            throw new UserNotFollowException(follower, followed);
        return iUserRepository.unfollow(follower, followed);
    }

    public void sortUserDTOByName(String order, List<User> list) throws InvalidOrderException {
        if (order.equals("name_asc")) {
            list.sort(COMPARATOR_NAME_ASC);
        } else if (order.equals("name_desc")) {
            list.sort(COMPARATOR_NAME_DES);
        } else if (!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }

}