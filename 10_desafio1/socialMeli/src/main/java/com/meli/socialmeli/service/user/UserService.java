package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.FollowersCountDTO;
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
    public void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException {
        User user = getValidUserById(userId);
        User userToFollow = getValidUserById(userIdToFollow);
        user.startToFollow(userToFollow);
        userRepository.save(user);
        userRepository.save(userToFollow);
    }

    private User getValidUserById(Integer userId) throws IdNotFoundException {
        return userRepository.findUserById(userId).orElseThrow(() -> new IdNotFoundException(userId));
    }

    @Override
    public FollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException {
        return SocialMeliMapper.toFollowersCountDTO(getValidUserById(userId));
    }
}
