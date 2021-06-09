package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;
import com.meli.socialmeli.exception.FollowException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.repository.user.IUserRepository;
import com.meli.socialmeli.service.SocialMeliMapper;
import com.meli.socialmeli.service.UserOrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException, FollowException {
        User user = getValidUserById(userId);
        User userToFollow = getValidUserById(userIdToFollow);
        sendToFollow(user, userToFollow);
        userRepository.save(user);
        userRepository.save(userToFollow);
    }

    private void sendToFollow(User user, User userToFollow) throws FollowException {
        if (user.isFollowing(userToFollow) || user.isTheSameUser(userToFollow))
            throw new FollowException(user.getUserId(), userToFollow.getUserId(), "follow, already following or is the same");
        user.startToFollow(userToFollow);
    }

    @Override
    public User getValidUserById(Integer userId) throws IdNotFoundException {
        return userRepository.findUserById(userId).orElseThrow(() -> new IdNotFoundException(userId));
    }

    @Override
    public UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException {
        return SocialMeliMapper.toFollowersCountDTO(getValidUserById(userId));
    }

    @Override
    public UserWithFollowersDTO followersOf(Integer userId, UserOrderType order) throws IdNotFoundException {
        UserWithFollowersDTO user = SocialMeliMapper.toFollowersDTO(getValidUserById(userId));
        if (order == null) return user;
        sortByName(user.getFollowers(), order);
        return user;
    }

    private void sortByName(List<UserDTO> list, UserOrderType order) {
        if (order.equals(UserOrderType.name_desc)) sortByNameDesc(list);
        else if (order.equals(UserOrderType.name_asc)) sortByNameAsc(list);
    }

    private void sortByNameAsc(List<UserDTO> list) {
        list.sort(Comparator.comparing(UserDTO::getUsername));
    }

    private void sortByNameDesc(List<UserDTO> list) {
        list.sort(Comparator.comparing(UserDTO::getUsername).reversed());
    }

    @Override
    public UserWithFollowedDTO followedOf(Integer userId, UserOrderType order) throws IdNotFoundException {
        UserWithFollowedDTO user = SocialMeliMapper.toFollowedDTO(getValidUserById(userId));
        if (order == null) return user;
        sortByName(user.getFollowed(), order);
        return user;
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) throws IdNotFoundException, FollowException {
        User user = getValidUserById(userId);
        User userToUnfollow = getValidUserById(userIdToUnfollow);
        sendToUnfollow(user, userToUnfollow);
        userRepository.save(user);
        userRepository.save(userToUnfollow);
    }

    private void sendToUnfollow(User user, User userIdToUnfollow) throws FollowException {
        if (!user.isFollowing(userIdToUnfollow))
            throw new FollowException(user.getUserId(), userIdToUnfollow.getUserId(), "unfollow, because is not following");
        user.stopToFollow(userIdToUnfollow);
    }
}
