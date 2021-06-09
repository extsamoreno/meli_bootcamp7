package socialmeli.socialmeli.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IUserRepository;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowedListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.UserRequestDto;
import socialmeli.socialmeli.project.services.mapper.mapper;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void followUser (UserRequestDto userRequestDto) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException {
        if(userRequestDto.getUserId() == userRequestDto.getUserIdToFollow()){
            throw new FollowMyselfException(userRequestDto.getUserId().toString());
        }
      if (iUserRepository.getUserFollowersList(userRequestDto.getUserIdToFollow())
              .stream()
              .anyMatch(user -> user.getUserId() == userRequestDto.getUserId())) {
          throw new FollowAlreadyException(userRequestDto.getUserIdToFollow().toString());
      }
        else{
          User userFollower = iUserRepository.findUserById(userRequestDto.getUserId());
          User userFollowed = iUserRepository.findUserById(userRequestDto.getUserIdToFollow());

          iUserRepository.getUserFollowersList(userRequestDto.getUserIdToFollow())
                  .add(new User(userFollower.getUserId(),userFollower.getUserName()));
          iUserRepository.getUserFollowedList(userRequestDto.getUserId())
                  .add(new User(userFollowed.getUserId(),userFollowed.getUserName()));
      }
    }

    @Override
    public FollowersResponseDto getFollowersCountById (String userId) throws IdNotFoundException {
        User u = iUserRepository.findUserById(Integer.parseInt(userId));
        return mapper.toFollowersResponseDto(u,iUserRepository.getUserFollowersList(Integer.parseInt(userId)).size());
    }

    @Override
    public FollowersListResponseDto getFollowersById(String userId) throws IdNotFoundException {
        User u = iUserRepository.findUserById(Integer.parseInt(userId));
        return mapper.toFollowersListResponseDto(u,iUserRepository.getUserFollowersList(Integer.parseInt(userId)));
    }

    @Override
    public FollowedListResponseDto getFollowedById(String userId) throws IdNotFoundException {
        User u = iUserRepository.findUserById(Integer.parseInt(userId));
        return mapper.toFollowedListResponseDto(u,iUserRepository.getUserFollowedList(Integer.parseInt(userId)));
    }
}
