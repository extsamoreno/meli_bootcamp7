package socialmeli.socialmeli.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IUserRepository;
import socialmeli.socialmeli.project.services.Dto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.FollowersResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserRequestDto;
import socialmeli.socialmeli.project.services.mapper.mapper;

import java.util.ArrayList;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    public void followUser (UserRequestDto userRequestDto) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException {
        if(userRequestDto.getUserId() == userRequestDto.getUserIdToFollow()){ //If you wan't to follow yourself
            throw new FollowMyselfException(userRequestDto.getUserId().toString());
        }

        User userFollower = iUserRepository.findUserById(userRequestDto.getUserId());

      if (iUserRepository.getUserFollowersList(userRequestDto.getUserIdToFollow()) //If you have already followed a user
              .stream()
              .anyMatch(user -> user.getUserId() == userRequestDto.getUserId())) {
          throw new FollowAlreadyException(userRequestDto.getUserIdToFollow().toString());
      }

        else
          iUserRepository.getUserFollowersList(userRequestDto.getUserIdToFollow())
                  .add(new User(userFollower.getUserId(),userFollower.getUserName()));
    }

    public FollowersResponseDto getFollowersCountById (String userId) throws IdNotFoundException {
        User u = iUserRepository.findUserById(Integer.parseInt(userId));
        return mapper.toFollowersResponseDto(u,iUserRepository.getUserFollowersList(Integer.parseInt(userId)).size());
    }

    public FollowersListResponseDto getFollowersById(String userId) throws IdNotFoundException {
        User u = iUserRepository.findUserById(Integer.parseInt(userId));
        return mapper.toFollowersListResponseDto(u,iUserRepository.getUserFollowersList(Integer.parseInt(userId)));
    }
}
