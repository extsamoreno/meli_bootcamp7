package meli.springchallenge.services;

import meli.springchallenge.dtos.FollowerCountDTO;
import meli.springchallenge.dtos.FollowListDTO;
import meli.springchallenge.exceptions.RelationNonExistentException;
import meli.springchallenge.exceptions.RelationNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.models.User;
import meli.springchallenge.repositories.IUserRepository;
import meli.springchallenge.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public FollowListDTO getFollowers(int userId, String order) throws UserNotValidException {

        String userName = userRepository.getUserById(userId).getUserName();
        List<User> followers= userRepository.getFollowers(userId);

        if( order.equals("name_desc")){
            followers.sort((f1, f2) -> f2.getUserName().compareTo(f1.getUserName()));
        }else if(order.equals("name_asc")) {
            followers.sort((f1, f2) -> f1.getUserName().compareTo(f2.getUserName()));
        }

        FollowListDTO response = new FollowListDTO();
        response.setUserId(userId);
        response.setUserName(userName);
        response.setRelateds(UserMapper.toDTO(followers));

        return response;
    }

    @Override
    public FollowListDTO getFollowed(int userId, String order) throws UserNotValidException {

        String userName = userRepository.getUserById(userId).getUserName();
        List<User> followed= userRepository.getFollowed(userId);

        if( order.equals("name_desc")){
            followed.sort((f1, f2) -> f2.getUserName().compareTo(f1.getUserName()));
        }else if(order.equals("name_asc")) {
            followed.sort((f1, f2) -> f1.getUserName().compareTo(f2.getUserName()));
        }

        FollowListDTO response = new FollowListDTO();
        response.setUserId(userId);
        response.setUserName(userName);
        response.setRelateds(UserMapper.toDTO(followed));

        return response;
    }

    @Override
    public String removeFollower(int userId, int userIdToUnfollow) throws RelationNonExistentException {
        int relationId = userRepository.removeFollower(userId, userIdToUnfollow);

        if (relationId < 0){
            throw new RelationNonExistentException(userId, userIdToUnfollow);
        }

        return "Relation #" + relationId + " removed";
    }


}
