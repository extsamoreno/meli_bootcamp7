package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.UserModel;
import meli.social.service.dto.UserFollowedListDTO;
import meli.social.service.dto.UserFollowersCounterDTO;
import meli.social.service.dto.UserFollowersListDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();
    void setFollower(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException;
    void removeFollower(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException;
    UserFollowersCounterDTO getFollowersCounter (int userId) throws UserIdNotFoundException;
    UserFollowersListDTO getFollowersList(int userId, String order) throws UserIdNotFoundException;
    UserFollowedListDTO  getFollowedList(int userId) throws UserIdNotFoundException;
}
