package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.*;
import com.example.socialmeli.mappers.UserMapper;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.UserList;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewUserRequestDTO;
import com.example.socialmeli.models.dtos.response.FollowSellerResponseDTO;
import com.example.socialmeli.models.dtos.response.FollowersCountResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedResponseDTO;
import com.example.socialmeli.models.dtos.response.ListFollowersResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImple implements UserRepository {
    private List<User> users = new ArrayList<>();
    private int count = 0;

    @Override
    public UserDTO addUser(NewUserRequestDTO newUser) throws ExistentUserException {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(newUser.getUserName())){
                throw new ExistentUserException(newUser.getUserName());
            }
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId(count);
        userDTO.setUserName(newUser.getUserName());

        User user = UserMapper.DTOToUser(userDTO);

        users.add(user);
        count++;

        return userDTO;
    }

    @Override
    public void followSeller(int userId, int userIdToFollow) throws InexistentUserException, ExistentFollowerException {
        User user = getUserById(userId);
        User userToFollow = getUserById(userIdToFollow);

        if(!(user.getFollowed() == null)){
            for (int j = 0; j < user.getFollowed().size(); j++) {
                UserList followed = user.getFollowed().get(j);

                if(followed.getUserId() == userIdToFollow){
                    throw new ExistentFollowerException(userId, userIdToFollow);
                }
            }
        }

        UserList follower = new UserList(user.getUserId(), user.getUserName());
        UserList followed = new UserList(userToFollow.getUserId(), userToFollow.getUserName());

        user.addFollowed(followed);
        userToFollow.addFollower(follower);
    }
    
    @Override
    public User getUserById(int userId) throws InexistentUserException {
        try{
            User foundUser = users.get(userId);

            return foundUser;
        } catch (Exception e){
            throw new InexistentUserException(userId);
        }
    }
    
    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> dtoUsers = null;

        for(User user : users){
            dtoUsers.add(UserMapper.UserToDTO(user));
        }
        
        return dtoUsers;
    }

    @Override
    public FollowersCountResponseDTO countResponse(int userId) throws InexistentUserException {
        User user = getUserById(userId);
        FollowersCountResponseDTO followersCountResponseDTO = new FollowersCountResponseDTO();

        followersCountResponseDTO.setUserId(userId);
        followersCountResponseDTO.setUserName(user.getUserName());
        followersCountResponseDTO.setFollowersCount(user.getFollowers().size());

        return followersCountResponseDTO;
    }

    @Override
    public ListFollowersResponseDTO listFollowers(int userId) throws InexistentUserException{
        User user = getUserById(userId);
        ListFollowersResponseDTO listFollowersResponseDTO = new ListFollowersResponseDTO();
        List<UserDTO> followers = null;

        for(UserList follower : user.getFollowers()){
            UserDTO followerDTO = new UserDTO(follower.getUserId(),follower.getUserName());
            followers.add(followerDTO);
        }

        listFollowersResponseDTO.setUserId(userId);
        listFollowersResponseDTO.setUserName(user.getUserName());
        listFollowersResponseDTO.setFollowers(followers);

        return listFollowersResponseDTO;
    }

    @Override
    public ListFollowedResponseDTO listFollowed (int userId) throws InexistentUserException{
        User user = getUserById(userId);
        ListFollowedResponseDTO listFollowedResponseDTO = new ListFollowedResponseDTO();
        List<UserDTO> followedList = null;

        for(UserList followed : user.getFollowed()){
            UserDTO followedDTO = new UserDTO(followed.getUserId(),followed.getUserName());
            followedList.add(followedDTO);
        }

        listFollowedResponseDTO.setUserId(userId);
        listFollowedResponseDTO.setUserName(user.getUserName());
        listFollowedResponseDTO.setFollowed(followedList);

        return listFollowedResponseDTO;
    }

    @Override
    public void unfollowSeller(int userId, int userIdToUnfollow) throws InexistentUserException, InexistentFollowerException{
        User user = getUserById(userId);
        User userToUnfollow = getUserById(userIdToUnfollow);
        boolean followerNotFound = true;

        if(!(user.getFollowed() == null)){
            for (int j = 0; j < user.getFollowed().size(); j++) {
                UserList followed = user.getFollowed().get(j);

                if(followed.getUserId() == userIdToUnfollow){
                    followerNotFound = false;
                    break;
                }
            }
        }

        if(followerNotFound){
            throw new InexistentFollowerException(userId, userIdToUnfollow);
        }

        UserList follower = new UserList(user.getUserId(), user.getUserName());
        UserList followed = new UserList(userToUnfollow.getUserId(), userToUnfollow.getUserName());

        user.deleteFollowed(followed);
        userToUnfollow.deleteFollower(follower);
    }
}
