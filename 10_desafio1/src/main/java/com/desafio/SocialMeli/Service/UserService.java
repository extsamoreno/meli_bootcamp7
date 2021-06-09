package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.Classes.User;
import com.desafio.SocialMeli.DTO.User.FollowedListDTO;
import com.desafio.SocialMeli.DTO.User.FollowersCountDTO;
import com.desafio.SocialMeli.DTO.User.FollowersListDTO;
import com.desafio.SocialMeli.DTO.User.UserDTO;
import com.desafio.SocialMeli.Exception.User.OrderNotFoundException;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserFollowedByHimselfException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Repository.User.IUserRepository;
import com.desafio.SocialMeli.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserDTO createUser(String userName) throws UserExistsException {
        if (iUserRepository.getAllUsers().stream().anyMatch(user -> user.getUserName().equals(userName))) {
            throw new UserExistsException(userName);
        } else {
            User user = new User();
            user.setUserName(userName);
            iUserRepository.saveUser(user);
            return UserMapper.toDTO(user);
        }
    }

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserFollowedByHimselfException {
        if (iUserRepository.getUserById(userId) != null) {
            if (iUserRepository.getUserById(userIdToFollow) != null) {
                if (userId != userIdToFollow) {
                    User user = iUserRepository.getUserById(userId);
                    User userToFollow = iUserRepository.getUserById(userIdToFollow);
                    user.setFollowed(userToFollow);
                    userToFollow.setFollowers(user);
                } else throw new UserFollowedByHimselfException(userId);
            } else throw new UserIdNotFoundException(userIdToFollow);
        } else  throw new UserIdNotFoundException(userId);
    }

    @Override
    public FollowersCountDTO getFollowersCount(int userId) throws UserIdNotFoundException {
        User user = iUserRepository.getUserById(userId);
        if (user != null) {
            return new FollowersCountDTO(user.getUserId(), user.getUserName(), user.getFollowersCount());
        } else throw new UserIdNotFoundException(userId);
    }

    @Override
    public FollowersListDTO getFollowersList(int userId, String order) throws UserIdNotFoundException, OrderNotFoundException {
        User user = iUserRepository.getUserById(userId);
        if (user != null) {
            List<User> userList = user.getFollowers();
            if (order == null) {
                return new FollowersListDTO(user.getUserId(), user.getUserName(), UserMapper.toListUserDTO(userList));
            } else switch(order)
                {
                    case "name_asc":
                        Collections.sort(userList);
                        break;
                    case "name_desc":
                        Collections.sort(userList, Collections.reverseOrder());
                        break;
                    default:
                        throw new OrderNotFoundException(order);
                }
            return new FollowersListDTO(user.getUserId(), user.getUserName(), UserMapper.toListUserDTO(userList));

        } else throw new UserIdNotFoundException(userId);
    }

    @Override
    public FollowedListDTO getFollowedList(int userId, String order) throws UserIdNotFoundException, OrderNotFoundException {
        User user = iUserRepository.getUserById(userId);
        if (user != null) {
            List<User> userList = user.getFollowed();
            if (order == null) {
                return new FollowedListDTO(user.getUserId(), user.getUserName(), UserMapper.toListUserDTO(userList));
            } else switch(order)
            {
                case "name_asc":
                    Collections.sort(userList);
                    break;
                case "name_desc":
                    Collections.sort(userList, Collections.reverseOrder());
                    break;
                default:
                    throw new OrderNotFoundException(order);
            }
            return new FollowedListDTO(user.getUserId(), user.getUserName(), UserMapper.toListUserDTO(userList));

        } else throw new UserIdNotFoundException(userId);
    }

    @Override
    public void unFollowUser(int userId, int userIdToUnFollow) throws UserIdNotFoundException, UserFollowedByHimselfException {
        if (iUserRepository.getUserById(userId) != null) {
            if (iUserRepository.getUserById(userIdToUnFollow) != null) {
                if (userId != userIdToUnFollow) {
                    User user = iUserRepository.getUserById(userId);
                    User userToUnFollow = iUserRepository.getUserById(userIdToUnFollow);
                    user.getFollowed().removeIf(u -> u.getUserId() == userIdToUnFollow);
                    userToUnFollow.getFollowers().removeIf(u -> u.getUserId() == userId);
                } else throw new UserFollowedByHimselfException(userId);
            } else throw new UserIdNotFoundException(userIdToUnFollow);
        } else  throw new UserIdNotFoundException(userId);
    }
}