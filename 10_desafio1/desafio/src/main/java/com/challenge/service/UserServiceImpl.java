package com.challenge.service;

import com.challenge.dto.FollowersCountResponse;
import com.challenge.dto.FollowersResponse;
import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void follow(Integer userId, Integer userToFollow) throws IOException, UserIdNotFoundException {
       if (!userRepository.checkIfExists(userId) || !userRepository.checkIfExists(userToFollow)) {
           throw new UserIdNotFoundException();
       }
       userRepository.follow(userId, userToFollow);
    }

    @Override
    public void unfollow(Integer userId, Integer userToUnfollow) throws UserIdNotFoundException, IOException {
        if (!userRepository.checkIfExists(userId) || !userRepository.checkIfExists(userToUnfollow)) {
            throw new UserIdNotFoundException();
        }
        userRepository.unfollow(userId, userToUnfollow);
    }

    @Override
    public FollowersCountResponse getFollowersCount(Integer userId) throws UserIdNotFoundException {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException();
        }
        return new FollowersCountResponse(userId, user.getUsername(), userRepository.getFollowersCount(userId));
    }

    @Override
    public FollowersResponse getFollowers(Integer userId, SortingUserEnum sorting) throws UserIdNotFoundException {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException();
        }
        List<User> follows = userRepository.getFollowers(userId);
        List<UserDTO> result = new ArrayList<>();
        for (User u : follows) {
            UserDTO dto = new UserDTO();
            dto.setUserId(u.getUserId());
            dto.setUsername(u.getUsername());
            dto.setFollows(UserMapper.toDTOList(userRepository.getFollows(u.getUserId())));
            result.add(dto);
        }
        sortByUsername(sorting, result);
        return new FollowersResponse(userId, user.getUsername(), result);
    }

    @Override
    public FollowersResponse getFollows(Integer userId, SortingUserEnum sorting) throws UserIdNotFoundException {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException();
        }
        List<User> follows = userRepository.getFollows(userId);
        List<UserDTO> result = UserMapper.toDTOList(follows);
        for (UserDTO u : result) {
            u.setFollows(UserMapper.toDTOList(userRepository.getFollows(u.getUserId())));
        }
        sortByUsername(sorting, result);
        return new FollowersResponse(userId, user.getUsername(), result);
    }

    private void sortByUsername(SortingUserEnum sorting, List<UserDTO> result) {
        if (sorting == null || sorting.equals(SortingUserEnum.name_desc)) {
            result.sort(Comparator.comparing(UserDTO::getUsername));
        } else {
            result.sort(Comparator.comparing(UserDTO::getUsername).reversed());
        }
    }
}
