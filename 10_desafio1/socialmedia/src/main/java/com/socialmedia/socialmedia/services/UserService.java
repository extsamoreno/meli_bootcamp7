package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.mappers.UserMapper;
import com.socialmedia.socialmedia.repositories.IFollowerRepository;
import com.socialmedia.socialmedia.repositories.IUserRepository;
import com.socialmedia.socialmedia.repositories.entities.Follower;
import com.socialmedia.socialmedia.repositories.entities.User;
import com.socialmedia.socialmedia.services.Helpers.SortPostHelper;
import com.socialmedia.socialmedia.services.dtos.UserCountFollowerDTO;
import com.socialmedia.socialmedia.services.dtos.UserDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IFollowerRepository followerRepository;

    @Override
    public void followToUser(int userId, int userIdToFollow)
            throws UserExistAsFollowerException, UserDistinctTypeException, ObjectNotFoundException {

        //TODO: Probar cuando llame a una relacion que este unfollow
        User userToFollow = userRepository.getById(userIdToFollow);
        User user = userRepository.getById(userId);

        if (userToFollow.getUserType() != 1) throw new UserDistinctTypeException(userToFollow.getId(), "vendedor");

        if (user.getUserType() != 2) throw new UserDistinctTypeException(user.getId(), "comprador");

        Follower existObject = followerRepository.getFollowerByUserIdAndFollowerId(userIdToFollow, userId);

        if (!Objects.isNull(existObject) && existObject.isFollow()) throw new UserExistAsFollowerException(userId, userIdToFollow);

        if (!Objects.isNull(existObject) && !existObject.isFollow()) {
            existObject.setFollow(true);
            followerRepository.update(existObject);
        }
        else followerRepository.add(new Follower(userIdToFollow, userId));
    }

    @Override
    public void unfollowToUser(int userId, int userIdToFollow) throws ObjectNotFoundException, UserNotExistAsFollowerException {
        User userToFollow = userRepository.getById(userIdToFollow);
        User user = userRepository.getById(userId);

        Follower existObject = followerRepository.getFollowerByUserIdAndFollowerId(userToFollow.getId(), user.getId());

        if (Objects.isNull(existObject)) throw new UserNotExistAsFollowerException(user.getId(), userToFollow.getId());

        existObject.setFollow(false);
        followerRepository.update(existObject);
    }

    @Override
    public UserCountFollowerDTO getCountFollowersByUser(int sellerId) throws ObjectNotFoundException, UserDistinctTypeException {
        User user = userRepository.getById(sellerId);

        if (user.getUserType() != 1) throw new UserDistinctTypeException(user.getId(), "vendedor");

        List<Follower> followers = followerRepository.getFollowersByUserId(user.getId())
                .stream().filter(f -> f.isFollow())
                .collect(Collectors.toList());

        UserCountFollowerDTO result = UserMapper.UserToUserCountFollowerDTO(user);

        result.setFollowers(followers.size());

        return result;
    }

    @Override
    public UserWithFollowersDTO getFollowersByUser(int userId, String order) throws ObjectNotFoundException, UserDistinctTypeException {
        List<User> results = new ArrayList<>();

        User user = userRepository.getById(userId);

        if (user.getUserType() != 1) throw new UserDistinctTypeException(user.getId(), "vendedor");

        List<Follower> followers = followerRepository.getFollowersByUserId(user.getId())
                .stream().filter(f -> f.isFollow())
                .collect(Collectors.toList());

        for (Follower follower : followers) {
            results.add(userRepository.getById(follower.getFollowerId()));
        }

        List<UserDTO> followersDTO = UserMapper.UsersToUsersDTO(results);

        if (order.equals("name_desc")) orderByName(followersDTO, true);
        else if (order.equals("name_asc")) orderByName(followersDTO, false);

        return UserMapper.UserToUserWithFollowersDTO(user, followersDTO);
    }

    private void orderByName(List<UserDTO> userDTOList, boolean isDescendent) {
        Collections.sort(userDTOList, (a,b) -> a.getUsername().compareTo(b.getUsername()));
        if (isDescendent) Collections.reverse(userDTOList);
    }

    @Override
    public UserWithFollowedDTO getFollowedByUser(int userId, String order) throws ObjectNotFoundException, UserDistinctTypeException {
        List<User> results = new ArrayList<>();

        User user = userRepository.getById(userId);

        if (user.getUserType() != 2) throw new UserDistinctTypeException(user.getId(), "comprador");

        List<Follower> followers = followerRepository.getFollowersByFollowerId(user.getId())
                .stream().filter(f -> f.isFollow())
                .collect(Collectors.toList());

        for (Follower follower : followers) {
            results.add(userRepository.getById(follower.getUserId()));
        }

        List<UserDTO> followersDTO = UserMapper.UsersToUsersDTO(results);


        if (order.equals("name_desc")) orderByName(followersDTO, true);
        else if (order.equals("name_asc")) orderByName(followersDTO, false);

        return UserMapper.UserToUserWithFollowedDTO(user, followersDTO);
    }
}
