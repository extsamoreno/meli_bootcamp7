package socialmeli.socialmeli.project.services;

import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowedListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.UserRequestDto;

public interface IUserService {
    public void followUser (UserRequestDto userRequestDto) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException;
    public FollowersResponseDto getFollowersCountById (String userId) throws IdNotFoundException;
    public FollowersListResponseDto getFollowersById(String userId) throws IdNotFoundException;
    public FollowedListResponseDto getFollowedById(String userId) throws IdNotFoundException;
}
