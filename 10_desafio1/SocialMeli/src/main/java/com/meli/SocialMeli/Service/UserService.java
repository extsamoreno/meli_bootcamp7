package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.CountUserFollowerDto;
import com.meli.SocialMeli.dto.CreateUserDto;
import com.meli.SocialMeli.dto.ListFollowersUserDto;
import com.meli.SocialMeli.dto.UserDto;
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

        UserDto userDto1 = new UserDto();
        userDto1.setIdUserDto(user1.getIdUser());
        userDto1.setUserNameDto(user1.getUserName());

        UserDto userDto2 = new UserDto();
        userDto2.setIdUserDto(user2.getIdUser());
        userDto2.setUserNameDto(user2.getUserName());

        List<UserDto> follow = user1.getFollowed();
        follow.add(userDto2);
        user1.setFollowed(follow);
        iUserRepository.UpdateUserList(user1);
        List<UserDto> followed = user2.getFollower();
        followed.add(userDto1);
        user2.setFollower(followed);
        iUserRepository.UpdateUserList(user2);

    }

    @Override
    public List<User> CreateUser(CreateUserDto createUserDto) {
        return iUserRepository.CreateUser(createUserDto);
    }

    @Override
    public List<User> getUsers() {
        return iUserRepository.getUsers();
    }

    @Override
    public CountUserFollowerDto getFollowersCount(int userId) {
        User userCount = iUserRepository.SearchIdUser(userId);
        return new CountUserFollowerDto(userCount.getIdUser(), userCount.getUserName(), userCount.getFollower().size());
    }

    @Override
    public ListFollowersUserDto getListFollowers(int userId) {
        User userListFollowers = iUserRepository.SearchIdUser(userId);
        return new ListFollowersUserDto(userListFollowers.getIdUser(), userListFollowers.getUserName(), userListFollowers.getFollower().stream().map(x->new UserDto(x.getIdUserDto(), x.getUserNameDto())).collect(Collectors.toList()));
    }

}

