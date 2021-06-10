package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;
import com.meli.socialmeli.exception.FollowException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidSortTypeException;
import com.meli.socialmeli.repository.user.IUserRepository;
import com.meli.socialmeli.service.mapper.UserMapper;
import com.meli.socialmeli.service.orderType.SortType;
import com.meli.socialmeli.service.orderType.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    /**
     * creates the follow relation between two users, adding each one to the other corresponding list
     * and update the users
     *
     * @param userId
     * @param userIdToFollow
     * @throws IdNotFoundException
     * @throws FollowException
     */
    @Override
    public void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException, FollowException {
        User user = getValidUserById(userId);
        User userToFollow = getValidUserById(userIdToFollow);
        sendToFollow(user, userToFollow);
        userRepository.save(user);
        userRepository.save(userToFollow);
    }

    /**
     * validate that one user can follow other and create the relation
     *
     * @param user
     * @param userToFollow
     * @throws FollowException
     */
    private void sendToFollow(User user, User userToFollow) throws FollowException {
        if (user.isFollowing(userToFollow) || user.isTheSameUser(userToFollow))
            throw new FollowException(user.getUserId(), userToFollow.getUserId(), "follow, already following or is the same");
        user.startToFollow(userToFollow);
    }

    /**
     * returns a not null user given an userId
     *
     * @param userId
     * @return
     * @throws IdNotFoundException
     */
    @Override
    public User getValidUserById(Integer userId) throws IdNotFoundException {
        return userRepository.findUserById(userId).orElseThrow(() -> new IdNotFoundException(userId));
    }

    /**
     * returns a UserWithFollowersCountDTO with the followers amount given a specific userId
     *
     * @param userId
     * @return
     * @throws IdNotFoundException
     */
    @Override
    public UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException {
        return UserMapper.toFollowersCountDTO(getValidUserById(userId));
    }

    /**
     * returns a UserWithFollowersDTO with the followers as a list UserDTO of a specific userId
     * sorted by the received criteria
     *
     * @param userId
     * @param order
     * @return
     * @throws IdNotFoundException
     * @throws InvalidSortTypeException
     */
    @Override
    public UserWithFollowersDTO followersOf(Integer userId, String order) throws IdNotFoundException, InvalidSortTypeException {
        UserWithFollowersDTO user = UserMapper.toFollowersDTO(getValidUserById(userId));
        if (order == null) return user;
        sortByName(user.getFollowers(), order);
        return user;
    }

    /**
     * sort a list of UserDTO with a given criteria
     *
     * @param list
     * @param order
     * @throws InvalidSortTypeException
     */
    private void sortByName(List<UserDTO> list, String order) throws InvalidSortTypeException {
        SortType sortType = Utils.getValidSortType(order);
        switch (sortType) {
            case name_asc:
                _asc:
                sortByNameAsc(list);
                break;
            case name_desc:
                sortByNameDesc(list);
                break;
            default:
                throw new InvalidSortTypeException(order);
        }
    }

    /**
     * sort a list of publication by ascending name
     *
     * @param list
     */
    private void sortByNameAsc(List<UserDTO> list) {
        list.sort(Comparator.comparing(UserDTO::getUsername));
    }

    /**
     * sort a list of publication by descending name
     *
     * @param list
     */
    private void sortByNameDesc(List<UserDTO> list) {
        list.sort(Comparator.comparing(UserDTO::getUsername).reversed());
    }

    /**
     * returns a UserWithFollowedDTO with the followed users as a list UserDTO of a specific userId
     * sorted by the received criteria
     *
     * @param userId
     * @param order
     * @return
     * @throws IdNotFoundException
     * @throws InvalidSortTypeException
     */
    @Override
    public UserWithFollowedDTO followedOf(Integer userId, String order) throws IdNotFoundException, InvalidSortTypeException {
        UserWithFollowedDTO user = UserMapper.toFollowedDTO(getValidUserById(userId));
        if (order == null) return user;
        sortByName(user.getFollowed(), order);
        return user;
    }

    /**
     * remove the follow relation between two users, removing each one to the other corresponding list
     * and update the users
     *
     * @param userId
     * @param userIdToUnfollow
     * @throws IdNotFoundException
     * @throws FollowException
     */
    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) throws IdNotFoundException, FollowException {
        User user = getValidUserById(userId);
        User userToUnfollow = getValidUserById(userIdToUnfollow);
        sendToUnfollow(user, userToUnfollow);
        userRepository.save(user);
        userRepository.save(userToUnfollow);
    }

    /**
     * validate that one user can unfollow other and remove the relation
     *
     * @param user
     * @param userIdToUnfollow
     * @throws FollowException
     */
    private void sendToUnfollow(User user, User userIdToUnfollow) throws FollowException {
        if (!user.isFollowing(userIdToUnfollow))
            throw new FollowException(user.getUserId(), userIdToUnfollow.getUserId(), "unfollow, because is not following");
        user.stopToFollow(userIdToUnfollow);
    }
}
