package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.repository.User;
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
public class UserService implements IUserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public HttpStatus follow(int userId, int useridToFollow) {
        User user = userRepository.getUserById(userId);
        User userFollowed = userRepository.getUserById(useridToFollow);
        user.getFollowed().add(userFollowed.getUserId());
        userRepository.refreshUser(user);
        return HttpStatus.OK;
    }

    @Override
    public CountFollowersDTO countFollowers(int userId) {
        User user = userRepository.getUserById(userId);
        CountFollowersDTO countFollowersDTO = new CountFollowersDTO();
        countFollowersDTO.setUserId(user.getUserId());
        countFollowersDTO.setUserName(user.getUserName());
        countFollowersDTO.setFollowers_count(this.getCountFollowers(userId));
        return countFollowersDTO;
    }

    @Override
    public FollowersListDTO getFollowerList(int userId) {
        User user = userRepository.getUserById(userId);
        FollowersListDTO followersListDTO = new FollowersListDTO();
        followersListDTO.setUserId(userId);
        followersListDTO.setUserName(user.getUserName());
        followersListDTO.setFollowers(this.getList(userId, false));
        return followersListDTO;
    }

    @Override
    public FollowedListDTO getFollowedList(int userId) {
        User user = userRepository.getUserById(userId);
        FollowedListDTO followedListDTO = new FollowedListDTO();
        followedListDTO.setUserId(userId);
        followedListDTO.setUserName(user.getUserName());
        followedListDTO.setFollowed(this.getList(userId, true));
        return followedListDTO;
    }

    @Override
    public HttpStatus unFollow(int userId, int useridToUnFollow) {
        User user = userRepository.getUserById(userId);
        User userFollowed = userRepository.getUserById(useridToUnFollow);
        for (int i=0;i<user.getFollowed().size();i++){
            if (user.getFollowed().get(i)==useridToUnFollow)
                user.getFollowed().remove(i);
        }
        userRepository.refreshUser(user);
        return HttpStatus.OK;
    }


    @Override
    public int getCountFollowers(int id) {
        List<User> users = userRepository.getAllUsers();
        int countFollowers = 0;
        for (int i=0; i<users.size();i++) {
            User userDb = users.get(i);
            for (int k=0; k<userDb.getFollowed().size();k++){
                if (userDb.getFollowed().get(k)==id) {
                    countFollowers += 1;
                }
            }
        }
        return  countFollowers;
    }

    @Override
    public ArrayList<UserDTO> getList(int id, boolean isFollowed) {
        List<User> users = userRepository.getAllUsers();
        ArrayList<UserDTO> followList = new ArrayList<>();
            for (int i = 0; i < users.size(); i++) {
                User userDb = users.get(i);
                if (isFollowed) {
                    if (userDb.getUserId() == id) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setUserId(users.get(i).getUserId());
                        userDTO.setUserName(users.get(i).getUserName());
                        followList.add(userDTO);
                    }
                }
                else {
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
