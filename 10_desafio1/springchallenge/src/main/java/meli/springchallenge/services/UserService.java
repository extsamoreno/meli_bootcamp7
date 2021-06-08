package meli.springchallenge.services;

import meli.springchallenge.dtos.FollowerCountDTO;
import meli.springchallenge.dtos.FollowListDTO;
import meli.springchallenge.dtos.UserDTO;
import meli.springchallenge.exceptions.RelationNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.models.User;
import meli.springchallenge.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public void addFollower(int follower, int following) throws UserNotValidException, RelationNotValidException {
        userRepository.addFollower(follower, following);
    }

    @Override
    public FollowerCountDTO countFollowers(int userId) throws UserNotValidException {

        String userName = userRepository.getUserById(userId).getUserName();
        int followers = userRepository.countFollowers(userId);

        return new FollowerCountDTO(userId, userName, followers);
    }

    @Override
    public FollowListDTO getFollowers(int userId) throws UserNotValidException {

        String userName = userRepository.getUserById(userId).getUserName();
        List<User> followers= userRepository.getFollowers(userId);

        FollowListDTO response = new FollowListDTO();
        response.setUserId(userId);
        response.setUserName(userName);
        response.setRelateds(userMapper(followers));

        return response;
    }

    @Override
    public FollowListDTO getFollowed(int userId) throws UserNotValidException {

        String userName = userRepository.getUserById(userId).getUserName();
        List<User> followed= userRepository.getFollowed(userId);

        FollowListDTO response = new FollowListDTO();
        response.setUserId(userId);
        response.setUserName(userName);
        response.setRelateds(userMapper(followed));

        return response;
    }

    private List<UserDTO> userMapper(List<User> users){

        return  users.stream().map(u-> new UserDTO(u.getUserId(), u.getUserName())).collect(Collectors.toList());

    }
}
