package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.UserWithFollowedDTO;
import com.meli.socialmeli.dto.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.UserWithFollowersDTO;
import com.meli.socialmeli.exception.CanNotFollowException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.repository.user.IUserRepository;
import com.meli.socialmeli.service.SocialMeliMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException, CanNotFollowException {
        User user = getValidUserById(userId);
        User userToFollow = getValidUserById(userIdToFollow);
        sendToFollow(user, userToFollow);
        userRepository.save(user);
        userRepository.save(userToFollow);
    }

    private void sendToFollow(User user, User userToFollow) throws CanNotFollowException {
        if (user.isFollowing(userToFollow)) throw new CanNotFollowException(user.getUserId(), userToFollow.getUserId());
        user.startToFollow(userToFollow);
    }

    private User getValidUserById(Integer userId) throws IdNotFoundException {
        return userRepository.findUserById(userId).orElseThrow(() -> new IdNotFoundException(userId));
    }

    @Override
    public UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException {
        return SocialMeliMapper.toFollowersCountDTO(getValidUserById(userId));
    }

    @Override
    public UserWithFollowersDTO followersOf(Integer userId) throws IdNotFoundException {
        return SocialMeliMapper.toFollowersDTO(getValidUserById(userId));
    }

    @Override
    public UserWithFollowedDTO followedOf(Integer userId) throws IdNotFoundException {
        return SocialMeliMapper.toFollowedDTO(getValidUserById(userId));
    }
}
