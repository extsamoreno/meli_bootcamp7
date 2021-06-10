package com.example.desafio1.services;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.user.*;
import com.example.desafio1.mappers.UserMapper;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;
import com.example.desafio1.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {
    // A to Z
    private final Comparator<UserDTO> COMPARATOR_NAME_ASC = Comparator.comparing(UserDTO::getUserName);
    // Z to A
    private final Comparator<UserDTO> COMPARATOR_NAME_DES = (a, b)->b.getUserName().compareTo(a.getUserName());

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public String createDB() {
        return iUserRepository.createDB();
    }

    @Override
    public UserDTO addUser(String name) {
        User user = new User(getNewId(), name);
        iUserRepository.addUser(user);
        return UserMapper.userToDTO(user);
    }

    @Override
    public User getUserById(int userId) throws InvalidUserIdException {
        return iUserRepository.getUserById(userId);
    }

    @Override
    public String followUser(int userId, int userIdToFollow) throws UserException {
        checkSameUser(userId, userIdToFollow);
        User user = iUserRepository.getUserById(userId);
        User userToFollow = iUserRepository.getUserById(userIdToFollow);
        checkIfFollowed(user, userToFollow.getUserId(), true);
        user.addFollowed(userToFollow.getUserId());
        userToFollow.addFollower(user.getUserId());
        return userId + " ha seguido a " + userIdToFollow;
    }

    @Override
    public String unfollowUser(int userId, int userIdToUnfollow) throws UserException {
        checkSameUser(userId, userIdToUnfollow);
        User user = iUserRepository.getUserById(userId);
        User userToUnfollow = iUserRepository.getUserById(userIdToUnfollow);
        checkIfFollowed(user, userToUnfollow.getUserId(), false);
        user.removeFollowed(userToUnfollow.getUserId());
        userToUnfollow.removeFollower(user.getUserId());
        return userId + " ha dejado de seguido a " + userIdToUnfollow;
    }

    @Override
    public ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowerCountDTO responseFollowerCountDTO = new ResponseFollowerCountDTO();
        responseFollowerCountDTO.setUserId(user.getUserId());
        responseFollowerCountDTO.setUserName(user.getUserName());
        responseFollowerCountDTO.setFollowersCount(user.getFollowers().size());
        return responseFollowerCountDTO;
    }

    @Override
    public ResponseFollowerListDTO getFollowersList(int userId, String order) throws UserException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowerListDTO responseFollowerListDTO = new ResponseFollowerListDTO();
        List<User> followers = getListOfUsersById(user.getFollowers());
        List<UserDTO> listFollowers = UserMapper.listUserToListUserDTO(followers);
        sortUserDTOByName(order, listFollowers);
        responseFollowerListDTO.setUserId(user.getUserId());
        responseFollowerListDTO.setUserName(user.getUserName());
        responseFollowerListDTO.setFollowers(listFollowers);
        return responseFollowerListDTO;
    }

    @Override
    public ResponseFollowedSellerDTO getFollowedSellers(int userId, String order) throws UserException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowedSellerDTO responseFollowedSellerDTO = new ResponseFollowedSellerDTO();
        List<UserDTO> listFollowed = getFollowedList(user.getUserId());
        sortUserDTOByName(order, listFollowed);
        responseFollowedSellerDTO.setUserId(user.getUserId());
        responseFollowedSellerDTO.setUserName(user.getUserName());
        responseFollowedSellerDTO.setFollowed(listFollowed);
        return responseFollowedSellerDTO;
    }

    @Override
    public List<UserDTO> getFollowedList(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        List<User> followed = getListOfUsersById(user.getFollowed());
        return UserMapper.listUserToListUserDTO(followed);
    }

    @Override
    public List<Post> getPostsList(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        return user.getPosts();
    }

    // Sort the List of UserDTO by name ascending or descending
    private void sortUserDTOByName(String order, List<UserDTO> list) throws InvalidOrderException {
        if(order.equals("name_asc")) {
            list.sort(COMPARATOR_NAME_ASC);
        } else if(order.equals("name_des")) {
            list.sort(COMPARATOR_NAME_DES);
        } else if(!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }

    // Transforms a list of userIds to a list of User
    private List<User> getListOfUsersById(List<Integer> userIdList) throws InvalidUserIdException {
        List<User> userList = new ArrayList<>();
        for(Integer id : userIdList) {
            userList.add(getUserById(id));
        }
        return userList;
    }

    // If is the same user, throws self follow / unfollow exception
    private void checkSameUser(int userId, int userIdToFollow) throws SelfFollowUnFollowException {
        if(userId == userIdToFollow) {
            throw new SelfFollowUnFollowException();
        }
    }

    // If the user is already following and want to follow the userid throw already follow exception
    // If the user is not following and want to unfollow the userid throw not followed exception
    private void checkIfFollowed(User user, int userId, boolean isFollow) throws AlreadyFollowException, NotFollowedException {
        if(user.getFollowed().contains(userId) && isFollow) {
            throw new AlreadyFollowException(userId);
        } else if(!user.getFollowed().contains(userId) && !isFollow) {
            throw new NotFollowedException(userId);
        }
    }

    private int getNewId() {
        return iUserRepository.getUsers().size() + 1;
    }
}
