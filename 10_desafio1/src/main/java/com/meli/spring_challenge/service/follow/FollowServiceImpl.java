package com.meli.spring_challenge.service.follow;

import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.model.User;
import com.meli.spring_challenge.repository.follow.FollowRepository;
import com.meli.spring_challenge.repository.user.UserRepository;
import com.meli.spring_challenge.service.dto.FollowersCountDto;
import com.meli.spring_challenge.service.dto.FollowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void followUser(int userID, int followedUserID) {
        Follow follow = new Follow();
        follow.setId(followRepository.getMaxID()+1);
        follow.setUserID(userID);
        follow.setFollowedUserID(followedUserID);
        followRepository.save(follow);
    }

    @Override
    public List<Follow> getAllFollows() {
        return followRepository.getAll();
    }

    @Override
    public FollowersCountDto getFollowCountByUserID(int userId) {
        FollowersCountDto result = new FollowersCountDto();
        User user = userRepository.getUserByID(userId);
        List<Follow> followList = followRepository.getAll();
        int count = 0;

        for(Follow follow : followList){
            if(follow.getFollowedUserID() == userId)
                count++;
        }

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setFollowsCount(count);

        return result;
    }

    @Override
    public FollowDto getFollowersByUserID(int userId) {
        FollowDto result = new FollowDto();
        User user = userRepository.getUserByID(userId);

        List<Follow> followList = followRepository.getAll().stream()
                .filter(follow -> follow.getFollowedUserID() == userId)
                .collect(Collectors.toList());

        List<User> userList = followList.stream()
                .map(follow -> userRepository.getUserByID(follow.getUserID()))
                .collect(Collectors.toList());

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setFollowerDtoList(userList);

        return result;
    }

    @Override
    public FollowDto getFollowedByUserID(int userID) {
        FollowDto result = new FollowDto();
        User user = userRepository.getUserByID(userID);
        List<Follow> followList = followRepository.getAll().stream()
                .filter(follow -> follow.getUserID() == userID)
                .collect(Collectors.toList());

        List<User> userList = followList.stream()
                .map(follow -> userRepository.getUserByID(follow.getFollowedUserID()))
                .collect(Collectors.toList());

        userList = userList.stream()
                .filter(user1 -> user1.isSeller() == true)
                .collect(Collectors.toList());

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setFollowerDtoList(userList);

        return result;
    }


}
