package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException {
        User user = userRepository.findUserById(userId).orElseThrow(() -> new IdNotFoundException(userId));
        User userToFollow = userRepository.findUserById(userIdToFollow).orElseThrow(() -> new IdNotFoundException(userIdToFollow));

        user.startToFollow(userToFollow);

        userRepository.save(user);
        userRepository.save(userToFollow);
    }
}
