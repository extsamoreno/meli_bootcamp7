package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.exception.FollowedExistingException;
import com.example.demo.socialmeli.exception.FollowedNotExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.models.User;
import com.example.demo.socialmeli.repository.UserRepository;
import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowedListDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import com.example.demo.socialmeli.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public HttpStatus follow(int userId, int useridToFollow) throws UserNotFoundException, FollowedExistingException {
        User user = userRepository.getUserById(userId);
        User userFollowed = userRepository.getUserById(useridToFollow);
        for (int i=0;i<user.getFollowed().size();i++) {
            if (user.getFollowed().get(i) == useridToFollow)
                throw new FollowedExistingException(useridToFollow);
        }
        user.getFollowed().add(useridToFollow);
        userRepository.refreshUser(user);
        return HttpStatus.OK;
    }

    @Override
    public CountFollowersDTO countFollowers(int userId) throws UserNotFoundException{
        User user = userRepository.getUserById(userId);
        CountFollowersDTO countFollowersDTO = new CountFollowersDTO();
        countFollowersDTO.setUserId(user.getUserId());
        countFollowersDTO.setUserName(user.getUserName());
        countFollowersDTO.setFollowers_count(this.getCountFollowers(userId));
        return countFollowersDTO;
    }

    @Override
    public FollowersListDTO getFollowerList(int userId, String order) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        FollowersListDTO followersListDTO = new FollowersListDTO();
        followersListDTO.setUserId(userId);
        followersListDTO.setUserName(user.getUserName());
        ArrayList<UserDTO> userDTOS = this.getList(userId, false);
        if (order != null) {
            if (order.equals("name_desc")) {
                userDTOS.sort((a, b) -> a.getUserName().compareTo(b.getUserName()));
            } else if (order.equals("name_asc")) {
                userDTOS.sort((a, b) -> b.getUserName().compareTo(a.getUserName()));
            }
        }
        followersListDTO.setFollowers(userDTOS);
        return followersListDTO;
    }

    @Override
    public FollowedListDTO getFollowedList(int userId, String order) throws UserNotFoundException{
        User user = userRepository.getUserById(userId);
        FollowedListDTO followedListDTO = new FollowedListDTO();
        followedListDTO.setUserId(userId);
        followedListDTO.setUserName(user.getUserName());
        ArrayList<UserDTO> userDTOS = this.getList(userId, true);
        if (order != null) {
            if (order.equals("name_desc")) {
                userDTOS.sort((a, b) -> a.getUserName().compareTo(b.getUserName()));
            } else if (order.equals("name_asc")) {
                userDTOS.sort((a, b) -> b.getUserName().compareTo(a.getUserName()));
            }
        }
        followedListDTO.setFollowed(userDTOS);
        return followedListDTO;
    }

    @Override
    public HttpStatus unFollow(int userId, int useridToUnFollow) throws UserNotFoundException, FollowedNotExistingException{
        User user = userRepository.getUserById(userId);
        User userToUnFollowed = userRepository.getUserById(useridToUnFollow);
        boolean notFollowed = true;
        for (int i = 0; i < user.getFollowed().size(); i++) {
            if (user.getFollowed().get(i) == useridToUnFollow) {
                user.getFollowed().remove(i);
                notFollowed = false;
            }
        }
        if (notFollowed)
            throw new FollowedNotExistingException(useridToUnFollow);
        userRepository.refreshUser(user);
        return HttpStatus.OK;
    }

    @Override
    public int getCountFollowers(int id) {
        List<User> users = userRepository.getAllUsers();
        int countFollowers = 0;
        for (int i = 0; i < users.size(); i++) {
            User userDb = users.get(i);
            for (int k = 0; k < userDb.getFollowed().size(); k++) {
                if (userDb.getFollowed().get(k) == id) {
                    countFollowers += 1;
                }
            }
        }
        return countFollowers;
    }

    @Override
    public ArrayList<UserDTO> getList(int id, boolean isFollowed) throws UserNotFoundException {
        List<User> users = userRepository.getAllUsers();
        ArrayList<UserDTO> followList = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User userDb = users.get(i);
            if (isFollowed) {
                if (userDb.getUserId() == id) {
                    for (int k = 0; k < userDb.getFollowed().size(); k++) {
                        User followed = userRepository.getUserById(userDb.getFollowed().get(k));
                        UserDTO userDTO = new UserDTO();
                        userDTO.setUserId(followed.getUserId());
                        userDTO.setUserName(followed.getUserName());
                        followList.add(userDTO);
                    }
                    break;
                }
            } else {
                for (int k = 0; k < userDb.getFollowed().size(); k++) {
                    if (userDb.getFollowed().get(k) == id) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setUserId(userDb.getUserId());
                        userDTO.setUserName(userDb.getUserName());
                        followList.add(userDTO);
                    }
                }
            }
        }
        return followList;
    }
}
