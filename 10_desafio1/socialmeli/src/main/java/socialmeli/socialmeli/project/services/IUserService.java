package socialmeli.socialmeli.project.services;

import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.UnfollowException;
import socialmeli.socialmeli.project.services.Dto.UserDto.*;

public interface IUserService {
    void unfollowUser(UserUnfollowRequestDto userUnfollowRequestDto) throws IdNotFoundException, UnfollowException;
    public void followUser (UserRequestDto userRequestDto) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException;
    public FollowersResponseDto getFollowersCountById (String userId) throws IdNotFoundException;
    public FollowersListResponseDto getFollowersById(String userId, String order) throws IdNotFoundException;
    public FollowedListResponseDto getFollowedById(String userId, String order) throws IdNotFoundException;
}
