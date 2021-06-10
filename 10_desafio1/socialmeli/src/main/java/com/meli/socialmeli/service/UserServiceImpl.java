package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.MissingParameterException;
import com.meli.socialmeli.exception.UserAlreadyFollowingUserException;
import com.meli.socialmeli.exception.UserNotExistsException;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.SellerDTO;
import com.meli.socialmeli.service.dto.UserBaseDTO;
import com.meli.socialmeli.service.dto.UserDTO;
import com.meli.socialmeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    private final Comparator<UserBaseDTO> comparatorNameAsc = Comparator.comparing(UserBaseDTO::getUserName);
    private final Comparator<UserBaseDTO> comparatorNameDesc = (a, b) -> b.getUserName().compareTo(a.getUserName());

    @Override
    public void createUserFromList(List<UserBaseDTO> userList) {
        userList.forEach(e -> userRepository.save(UserMapper.BaseDTOToModel(e)));
    }

    @Override
    public List<UserBaseDTO> getUserList() {
        return userRepository.getUserList().stream().map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
    }

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotExistsException, UserAlreadyFollowingUserException {
        userExists(userId);
        userExists(userIdToFollow);
        if (userRepository.userFollowingUserById(userId,userIdToFollow)) {
            throw new UserAlreadyFollowingUserException();
        }
        userRepository.followUser(userId, userIdToFollow);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) throws UserNotExistsException {
        userExists(userId);
        userExists(userIdToUnfollow);
        userRepository.UnfollowUser(userId, userIdToUnfollow);
    }

    @Override
    public int countFollowersByUserId(Optional<Integer> userId) throws UserNotExistsException, MissingParameterException {
        if (userId.isPresent()) {
            userExists(userId.get());
            return userRepository.countFollowersByUserId(userId.get());
        } else {
            throw new MissingParameterException("userId");
        }
    }

    @Override
    public SellerDTO getFollowersByUserId(Optional<Integer> userId, String order) throws UserNotExistsException, MissingParameterException {
        if (userId.isPresent()) {
            userExists(userId.get());
            List<UserBaseDTO> followers = userRepository.getFollowersByUserId(userId.get()).stream().map(this::getUserById).map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
            sortListByOrder(followers, order);
            return UserMapper.modelToSellerDTO(getUserById(userId.get()), followers);
        } else {
            throw new MissingParameterException("userId");
        }
    }

    @Override
    public UserDTO getFollowingByUserId(Optional<Integer> userId, String order) throws UserNotExistsException, MissingParameterException {
        if (userId.isPresent()) {
            userExists(userId.get());
            List<UserBaseDTO> following = userRepository.getFollowingByUserId(userId.get()).stream().map(this::getUserById).map(UserMapper::modelToDBaseDTO).collect(Collectors.toList());
            sortListByOrder(following, order);
            return UserMapper.modelToUserDTO(getUserById(userId.get()), following);
        } else {
            throw new MissingParameterException("userId");
        }
    }

    private User getUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void userExists(int userId) throws UserNotExistsException {
        User user = getUserById(userId);
        if (user == null) {
            throw new UserNotExistsException(userId);
        }
    }

    private void sortListByOrder(List<UserBaseDTO> list, String order) {
        if (order.compareTo("name_asc") == 0) {
            list.sort(comparatorNameAsc);
        } else {
            list.sort(comparatorNameDesc);
        }
    }

}
