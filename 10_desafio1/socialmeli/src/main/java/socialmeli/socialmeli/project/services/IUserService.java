package socialmeli.socialmeli.project.services;

import org.springframework.http.ResponseEntity;
import socialmeli.socialmeli.project.exceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.*;

public interface IUserService {
    public void followUser (UserRequestDto userRequestDto) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException;
    public FollowersResponseDto getFollowersCountById (String userId) throws IdNotFoundException;
    public FollowersListResponseDto getFollowersById(String userId) throws IdNotFoundException;
    public FollowedListResponseDto getFollowedById(String userId) throws IdNotFoundException;
}
