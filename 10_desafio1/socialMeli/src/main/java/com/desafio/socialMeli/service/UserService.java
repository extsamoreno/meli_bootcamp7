package com.desafio.socialMeli.service;

import com.desafio.socialMeli.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.exceptions.UserNotFoundException;
import com.desafio.socialMeli.repository.IUserRepository;
import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;
import com.desafio.socialMeli.service.dto.UserFollowedDTO;
import com.desafio.socialMeli.service.dto.UserFollowersCountDTO;
import com.desafio.socialMeli.service.dto.UserFollowersDTO;
import com.desafio.socialMeli.service.mapper.UserDTOMapper;
import com.desafio.socialMeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public String loadDatabaseDTO(){
        iUserRepository.getOrCreateUserDTORepository();
        for(User user: iUserRepository.getUserList()) {
            UserDTO userDTOtoLoad = UserMapper.toUserDTO(user);
            iUserRepository.updateUserDTORepository(userDTOtoLoad);
        }
        return "UserDTO database creada";
    }

    @Override
    public String followById(Integer userId, Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException {
        if(!iUserRepository.repositoryStatus()) throw new RepositoryUnableException();
        UserDTO userDTOtoFollow = getUserDTOById(userIdToFollow);
        UserDTO userDTOFollower = getUserDTOById(userId);

        userDTOtoFollow.addFollower(iUserRepository.getUserById(userId));
        userDTOFollower.addFollowed(iUserRepository.getUserById(userIdToFollow));

        iUserRepository.updateUserDTORepository(userDTOtoFollow);
        iUserRepository.updateUserDTORepository(userDTOFollower);

        return ("el usuario " + iUserRepository.getUserById(userId).getName() + " ahora sigue a " + userDTOtoFollow.getName());
    }


    @Override
    public String unfollowById(Integer userId, Integer userIdToUnFollow) throws UserNotFoundException, RepositoryUnableException, RemoveFollowerException, RemoveFollowedException {
        if(!iUserRepository.repositoryStatus()) throw new RepositoryUnableException();
        UserDTO userDTOtoUnfollow = getUserDTOById(userIdToUnFollow); // usuario seguido
        UserDTO userDTOFollower = getUserDTOById(userId);   // usuario seguidor

        if(!userDTOFollower.removeFollowed(iUserRepository.getUserById(userIdToUnFollow))) throw new RemoveFollowerException(userDTOtoUnfollow.getName());
        if(!userDTOtoUnfollow.removeFollower(iUserRepository.getUserById(userId))) throw new RemoveFollowedException(userDTOFollower.getName());

        iUserRepository.updateUserDTORepository(userDTOFollower);
        iUserRepository.updateUserDTORepository(userDTOtoUnfollow);

        return ("el usuario " + userDTOFollower.getName() + " ahora dejo de seguir a " + userDTOtoUnfollow.getName());
    }


    private UserDTO getUserDTOById(Integer userDTOId) throws UserNotFoundException{
        UserDTO userDTOtoFollow = iUserRepository.getUserDTOById(userDTOId);
        if(userDTOtoFollow == null) throw new UserNotFoundException();
        return userDTOtoFollow;
    }

    @Override
    public UserFollowersCountDTO followersCount(Integer userId) throws  RepositoryUnableException, UserNotFoundException{
        if(!iUserRepository.repositoryStatus()) throw new RepositoryUnableException();
        UserDTO userDTO = getUserDTOById(userId);
        return UserDTOMapper.toUserFollowersCountDTO(userDTO, userId);
    }

    @Override
    public UserFollowersDTO followersList(Integer userId) throws  RepositoryUnableException, UserNotFoundException{
        if(!iUserRepository.repositoryStatus()) throw new RepositoryUnableException();
        UserDTO userDTO = getUserDTOById(userId);
        return UserDTOMapper.toUserFollowersDTO(userDTO, userId);
    }

    @Override
    public UserFollowedDTO followedList(Integer userId) throws  RepositoryUnableException, UserNotFoundException{
        if(!iUserRepository.repositoryStatus()) throw new RepositoryUnableException();
        UserDTO userDTO = getUserDTOById(userId);
        return UserDTOMapper.toUserFollowedListDTO(userDTO, userId);
    }
}

