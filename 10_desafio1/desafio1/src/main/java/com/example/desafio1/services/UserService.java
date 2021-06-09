package com.example.desafio1.services;

import com.example.desafio1.dtos.ResponseFollowedSellerDTO;
import com.example.desafio1.dtos.ResponseFollowerCountDTO;
import com.example.desafio1.dtos.ResponseFollowerListDTO;
import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.InvalidOrderException;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.exceptions.UserException;
import com.example.desafio1.mappers.UserMapper;
import com.example.desafio1.models.Post;
import com.example.desafio1.models.User;
import com.example.desafio1.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {
    // A to Z
    private final Comparator<UserDTO> COMPARATOR_NAME_ASC = (a, b)->a.getUserName().compareTo(b.getUserName());
    // Z to A
    private final Comparator<UserDTO> COMPARATOR_NAME_DES = (a, b)->b.getUserName().compareTo(a.getUserName());

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public String createDB() {
        return iUserRepository.createDB();
    }

    @Override
    public User getUserById(int userId) throws InvalidUserIdException {
        return iUserRepository.getUserById(userId);
    }

    @Override
    public String followUser(int userId, int userIdToFollow) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        User userToFollow = iUserRepository.getUserById(userIdToFollow);
        user.addFollowed(UserMapper.UserToDTO(userToFollow));
        userToFollow.addFollower(UserMapper.UserToDTO(user));
        return userId + " ha seguido a " + userIdToFollow;
    }

    @Override
    public String unfollowUser(int userId, int userIdToUnfollow) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        User userToUnfollow = iUserRepository.getUserById(userIdToUnfollow);
        user.removeFollowed(UserMapper.UserToDTO(userToUnfollow));
        userToUnfollow.removeFollower(UserMapper.UserToDTO(user));
        return userId + " ha dejado de seguido a " + userIdToUnfollow;
    }

    @Override
    public ResponseFollowerCountDTO getFollowersCount(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowerCountDTO responseFollowerCountDTO = new ResponseFollowerCountDTO();
        responseFollowerCountDTO.setUserId(user.getUserId());
        responseFollowerCountDTO.setUserName(user.getUserName());
        responseFollowerCountDTO.setFollowers_count(user.getFollowers().size());
        return responseFollowerCountDTO;
    }

    @Override
    public ResponseFollowerListDTO getFollowersList(int userId, String order) throws UserException {
        User user = iUserRepository.getUserById(userId);
        ResponseFollowerListDTO responseFollowerListDTO = new ResponseFollowerListDTO();
        List<UserDTO> listFollowers = user.getFollowers();
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
        List<UserDTO> listFollowed = user.getFollowed();
        sortUserDTOByName(order, listFollowed);
        responseFollowedSellerDTO.setUserId(user.getUserId());
        responseFollowedSellerDTO.setUserName(user.getUserName());
        responseFollowedSellerDTO.setFollowed(listFollowed);
        return responseFollowedSellerDTO;
    }

    @Override
    public List<UserDTO> getFollowedList(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        return user.getFollowed();
    }

    @Override
    public List<Post> getPostsList(int userId) throws InvalidUserIdException {
        User user = iUserRepository.getUserById(userId);
        return user.getPosts();
    }

    public void sortUserDTOByName(String order, List<UserDTO> list) throws InvalidOrderException {
        if(order.equals("name_asc")) {
            list.sort(COMPARATOR_NAME_ASC);
        } else if(order.equals("name_des")) {
            list.sort(COMPARATOR_NAME_DES);
        } else if(!order.equals("")) {
            throw new InvalidOrderException(order);
        }
    }
}
