package com.meli.spring_challenge.service.follow;

import com.meli.spring_challenge.exception.user.*;
import com.meli.spring_challenge.model.Follow;
import com.meli.spring_challenge.model.User;
import com.meli.spring_challenge.repository.follow.FollowRepository;
import com.meli.spring_challenge.repository.user.UserRepository;
import com.meli.spring_challenge.service.dto.FollowersCountDto;
import com.meli.spring_challenge.service.dto.FollowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    FollowRepository followRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void followUser(int userID, int followedUserID) throws UserNotFoundException, UserFollowException {

        if(userRepository.getUserByID(userID) == null){
            throw new UserNotFoundException(userID);
        }

        if(userRepository.getUserByID(followedUserID) == null){
            throw new UserNotFoundException(followedUserID);
        }

        if(followRepository.getFollow(userID,followedUserID) != null || userID == followedUserID){
            throw new UserFollowException(userID, followedUserID);
        }

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
    public FollowersCountDto getFollowCountByUserID(int userId) throws UserNotFoundException {
        FollowersCountDto result = new FollowersCountDto();
        User user = userRepository.getUserByID(userId);

        if(user == null){
            throw new UserNotFoundException(userId);
        }

        List<Follow> followList = followRepository.getAll();
        int count = 0;

        for(Follow follow : followList){
            if(follow.getFollowedUserID() == userId)
                count++;
        }

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setFollowers_count(count);

        return result;
    }

    @Override
    public FollowDto getFollowersByUserID(int userId) throws UserNotFoundException, UserNotSellerException {
        FollowDto result = new FollowDto();
        User user = userRepository.getUserByID(userId);

        if(user == null)
            throw new UserNotFoundException(userId);


        if(!user.isSeller())
            throw  new UserNotSellerException(userId);

        List<Follow> followList = followRepository.getAll().stream()
                .filter(follow -> follow.getFollowedUserID() == userId)
                .collect(Collectors.toList());

        List<User> userList = followList.stream()
                .map(follow -> userRepository.getUserByID(follow.getUserID()))
                .filter(user1 -> !user1.isSeller())
                .collect(Collectors.toList());


        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setFollowed(userList);

        return result;
    }

    @Override
    public FollowDto getFollowedByUserID(int userID, String order) throws UserNotFoundException, UserGuestException {
        FollowDto result = new FollowDto();
        User user = userRepository.getUserByID(userID);

        if(user == null){
            throw new UserNotFoundException(userID);
        }

        if(user.isSeller()){
            throw new UserGuestException(userID);
        }

        List<Follow> followList = followRepository.getAll().stream()
                .filter(follow -> follow.getUserID() == userID)
                .collect(Collectors.toList());

        List<User> userList = followList.stream()
                .map(follow -> userRepository.getUserByID(follow.getFollowedUserID()))
                .filter(user1 -> user1.isSeller())
                .collect(Collectors.toList());


        if(order != null && order.equals("name_asc")){
                Collections.sort(userList, new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getUserName().compareTo(o2.getUserName());
                    }
                });
            }else{
            Collections.sort(userList, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return o2.getUserName().compareTo(o1.getUserName());
                }
            });
        }

        result.setUserID(user.getUserID());
        result.setUserName(user.getUserName());
        result.setSeller(user.isSeller());
        result.setFollowed(userList);

        return result;
    }

    @Override
    public void unfollowUser(int userID, int userIdToFollow) throws UserRelationNotFoundException, UserNotFoundException {
        List<Follow> followList = followRepository.getAll();
        User user1 = userRepository.getUserByID(userID);
        User user2 = userRepository.getUserByID(userID);

        if(user1 == null || user2 == null){
            throw new UserNotFoundException(userID);
        }

        Follow result = followList.stream()
                .filter(follow -> follow.getUserID() == userID && follow.getFollowedUserID() == userIdToFollow)
                .findFirst()
                .orElse(null);

        if(result == null){
            throw new UserRelationNotFoundException(userID,userIdToFollow);
        }

        followRepository.remove(result);

    }


}
