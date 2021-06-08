package com.example.socialmeli.repository;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public ResponseStatus userAdd(UserDTO userDTO) {
        User user = new User();
        if (users.size() > 0)
            user.setUserId(users.get(users.size() - 1).getUserId() + 1);
        else
            user.setUserId(1);
        user.setUserName(userDTO.getUserName());
        user.setFollowed(new ArrayList<>());
        user.setFollowers(new ArrayList<>());
        user.setPosts(new ArrayList<>());
        users.add(user);
        return null;
    }

    @Override
    public ResponseStatus userAddList(List<UserDTO> userDTO) {
        for (UserDTO obj : userDTO) {
            userAdd(obj);
        }
        return null;
    }

    @Override
    public UserFolCouResponseDTO getFollowersCount(int userId) {
        for (User obj : users) {
            if (obj.getUserId() == userId) {
                return new UserFolCouResponseDTO(obj.getUserId(), obj.getUserName(), obj.getFollowers().size());
            }
        }
        return null;
    }

    @Override
    public UserFolsLisResponseDTO getFollowersList(int userId) {
        for (User obj : users) {
            if (obj.getUserId() == userId) {
                List<UserDTO> userDTOS = new ArrayList<>();
                for (User objDTO : obj.getFollowers()) {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setUserId(objDTO.getUserId());
                    userDTO.setUserName(objDTO.getUserName());
                    userDTOS.add(userDTO);
                }
                return new UserFolsLisResponseDTO(obj.getUserId(), obj.getUserName(), userDTOS);
            }
        }
        return null;
    }

    @Override
    public UserFolLisResponseDTO getFollowedList(int userId) {
        for (User obj : users) {
            if (obj.getUserId() == userId) {
                List<UserDTO> userDTOS = new ArrayList<>();
                for (User objDTO : obj.getFollowed()) {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setUserId(objDTO.getUserId());
                    userDTO.setUserName(objDTO.getUserName());
                    userDTOS.add(userDTO);
                }
                return new UserFolLisResponseDTO(obj.getUserId(), obj.getUserName(), userDTOS);
            }
        }
        return null;
    }

    @Override
    public boolean userFollow(int userid, int useridFollow) {
        try {
            User userFollow = null, userFollowed = null;
            if (userid != useridFollow)
                for (User obj : users) {
                    if (obj.getUserId() == userid)
                        userFollow = obj;
                    if (obj.getUserId() == useridFollow)
                        userFollowed = obj;
                    if (userFollow != null && userFollowed != null) {
                        userFollow.addFollowed(userFollowed);
                        userFollowed.addFollowers(userFollow);
                    }
                }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean userUnFollow(int userid, int useridFollow) {
        try {
            User userFollow = null, userFollowed = null;
            if (userid != useridFollow)
                for (User obj : users) {
                    if (obj.getUserId() == userid)
                        userFollow = obj;
                    if (obj.getUserId() == useridFollow)
                        userFollowed = obj;
                    if (userFollow != null && userFollowed != null) {
                        userFollow.removeFollowed(userFollowed);
                        userFollowed.removeFollowers(userFollow);
                    }
                }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
