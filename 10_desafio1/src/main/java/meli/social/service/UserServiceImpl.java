package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.UserModel;
import meli.social.repository.UserRepository;
import meli.social.service.dto.UserDTO;
import meli.social.service.dto.UserFollowedListDTO;
import meli.social.service.dto.UserFollowersCounterDTO;
import meli.social.service.dto.UserFollowersListDTO;
import meli.social.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    // Prueba seed Json
    @Override
    public List<UserModel> getAllUsers() {
       return userRepository.seedDb();
    }

    @Override
    public HttpStatus setFollower(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException {
        UserModel user = userRepository.findUserById(userId);
        UserModel userToFollow = userRepository.findUserById(userIdToFollow);

        user.getFollowed().add(userIdToFollow);
        userToFollow.getFollowers().add(userId);

        // Falta validación de si ya se están siguiendo
        userRepository.saveChangesDb(user, userToFollow);
        return HttpStatus.OK;
    }

    @Override
    public UserFollowersCounterDTO getFollowersCounter (int userId) throws UserIdNotFoundException {
        UserModel user = userRepository.findUserById(userId);
        return UserMapper.toFollowersCounterDto(user);
    }

    @Override
    public UserFollowersListDTO getFollowersList(int userId) throws UserIdNotFoundException {
        UserModel user = userRepository.findUserById(userId);

        List<UserDTO> followers = new ArrayList<>();
        for (int i = 0; i < user.getFollowers().size(); i++) {
            int idFollower = user.getFollowers().get(i);
            String nameFollower = userRepository.findUserById(idFollower).getUserName();
            followers.add(new UserDTO(idFollower, nameFollower));
        }
        return UserMapper.toFollowersListDto(user, followers);
    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId) throws UserIdNotFoundException {
        UserModel user = userRepository.findUserById(userId);

        List<UserDTO> followed = new ArrayList<>();
        for (int i = 0; i < user.getFollowed().size(); i++) {
            int idFollowed = user.getFollowed().get(i);
            String nameFollowed = userRepository.findUserById(idFollowed).getUserName();
            followed.add(new UserDTO(idFollowed, nameFollowed));
        }
        return UserMapper.toFollowedListDto(user, followed);
    }
}
