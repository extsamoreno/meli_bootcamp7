package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.UserModel;
import meli.social.repository.DataRepository;
import meli.social.service.dto.UserDTO;
import meli.social.service.dto.UserFollowedListDTO;
import meli.social.service.dto.UserFollowersCounterDTO;
import meli.social.service.dto.UserFollowersListDTO;
import meli.social.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    DataRepository dataRepository;

    @Override
    public List<UserModel> getAllUsers() {
       return dataRepository.getUsersDb();
    }

    @Override
    public void setFollower(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException {
        UserModel user = dataRepository.findUserById(userId);
        UserModel userToFollow = dataRepository.findUserById(userIdToFollow);

        if (!user.getFollowed().contains(userIdToFollow)) {
            user.getFollowed().add(userIdToFollow);
            userToFollow.getFollowers().add(userId);
        }
        dataRepository.saveUserDb(user, userToFollow);
    }

    @Override
    public void removeFollower(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException {
        UserModel user = dataRepository.findUserById(userId);
        UserModel userToUnfollow = dataRepository.findUserById(userIdToUnfollow);

        for (int i = 0; i < user.getFollowed().size(); i++) {
            if (user.getFollowed().get(i) == userIdToUnfollow) user.getFollowed().remove(i);
        }
        for (int i = 0; i < userToUnfollow.getFollowers().size(); i++) {
            if (userToUnfollow.getFollowers().get(i) == userId) userToUnfollow.getFollowers().remove(i);
        }

        dataRepository.saveUserDb(user, userToUnfollow);
    }

    @Override
    public UserFollowersCounterDTO getFollowersCounter (int userId) throws UserIdNotFoundException {
        UserModel user = dataRepository.findUserById(userId);
        return UserMapper.toFollowersCounterDto(user);
    }

    @Override
    public UserFollowersListDTO getFollowersList(int userId, String order) throws UserIdNotFoundException {
        UserModel user = dataRepository.findUserById(userId);

        List<UserDTO> followers = new ArrayList<>();
        for (int i = 0; i < user.getFollowers().size(); i++) {
            int idFollower = user.getFollowers().get(i);
            String nameFollower = dataRepository.findUserById(idFollower).getUserName();
            followers.add(new UserDTO(idFollower, nameFollower));
        }
        // Ordena la lista alfabeticamente por su nombre
        Comparator<UserDTO> nameComparator = Comparator.comparing(u -> u.getUserName().toLowerCase());
        if (order.equals("name_asc")) followers.sort(nameComparator);
        if (order.equals("name_desc")) followers.sort(nameComparator.reversed());

        return UserMapper.toFollowersListDto(user, followers);
    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId) throws UserIdNotFoundException {
        UserModel user = dataRepository.findUserById(userId);

        List<UserDTO> followed = new ArrayList<>();
        for (int i = 0; i < user.getFollowed().size(); i++) {
            int idFollowed = user.getFollowed().get(i);
            String nameFollowed = dataRepository.findUserById(idFollowed).getUserName();
            followed.add(new UserDTO(idFollowed, nameFollowed));
        }
        return UserMapper.toFollowedListDto(user, followed);
    }
}

// Comentario para poder pushear a la nueva branch