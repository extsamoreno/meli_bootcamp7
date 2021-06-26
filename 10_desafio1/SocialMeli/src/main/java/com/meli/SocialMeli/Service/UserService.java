package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.CountUserFollowerDTO;
import com.meli.SocialMeli.dto.CreateUserDTO;
import com.meli.SocialMeli.dto.ListFollowersUserDTO;
import com.meli.SocialMeli.dto.UserDTO;
import com.meli.SocialMeli.exceptions.UserIsNotSeller;
import com.meli.SocialMeli.exceptions.UserNotFoundException;
import com.meli.SocialMeli.models.User;
import com.meli.SocialMeli.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void FollowUser(int userId, int userIdToFollow) throws UserNotFoundException, UserIsNotSeller {
        User user1 = iUserRepository.SearchIdUser(userId);
        User user2 = iUserRepository.SearchIdUser(userIdToFollow);

        if (user1 == null || user2 == null){
            throw new UserNotFoundException("No se encontro un usuario registrado");
        }
        if (!user2.isEsVendedor()){
            throw new UserIsNotSeller("El usuario no es vendedor");
        }

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setIdUserDto(user1.getIdUser());
        userDTO1.setUserNameDto(user1.getUserName());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setIdUserDto(user2.getIdUser());
        userDTO2.setUserNameDto(user2.getUserName());

        List<UserDTO> follow = user1.getFollowed();
        follow.add(userDTO2);
        user1.setFollowed(follow);
        iUserRepository.UpdateUserList(user1);
        List<UserDTO> followed = user2.getFollower();
        followed.add(userDTO1);
        user2.setFollower(followed);
        iUserRepository.UpdateUserList(user2);

    }

    @Override
    public List<User> CreateUser(CreateUserDTO createUserDto) {
        return iUserRepository.CreateUser(createUserDto);
    }

    @Override
    public List<User> getUsers() {
        return iUserRepository.getUsers();
    }

    @Override
    public CountUserFollowerDTO getFollowersCount(int userId) {
        User userCount = iUserRepository.SearchIdUser(userId);
        return new CountUserFollowerDTO(userCount.getIdUser(), userCount.getUserName(), userCount.getFollower().size());
    }

    @Override
    public ListFollowersUserDTO getListFollowers(int userId) {
        User userListFollowers = iUserRepository.SearchIdUser(userId);
        return new ListFollowersUserDTO(userListFollowers.getIdUser(), userListFollowers.getUserName(), userListFollowers.getFollower().stream().map(x->new UserDTO(x.getIdUserDto(), x.getUserNameDto())).collect(Collectors.toList()));
    }

}

