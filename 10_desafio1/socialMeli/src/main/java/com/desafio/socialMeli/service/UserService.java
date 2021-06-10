package com.desafio.socialMeli.service;

import com.desafio.socialMeli.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.exceptions.UserNotFoundException;
import com.desafio.socialMeli.repository.ISocialMeliRepository;
import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;
import com.desafio.socialMeli.service.dto.UserFollowedDTO;
import com.desafio.socialMeli.service.dto.UserFollowersCountDTO;
import com.desafio.socialMeli.service.dto.UserFollowersDTO;
import com.desafio.socialMeli.service.mapper.UserDTOMapper;
import com.desafio.socialMeli.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.desafio.socialMeli.repository.SocialMeliRepository.USERDTO_TABLE;

@Service
public class UserService implements IUserService {

    @Autowired
    ISocialMeliRepository iSocialMeliRepository;

    @Override
    public String loadDatabaseDTO(){
        iSocialMeliRepository.getOrCreateDTOTable(USERDTO_TABLE);
        for(User user: iSocialMeliRepository.getUserList()) {
            UserDTO userDTOtoLoad = UserMapper.toUserDTO(user);
            iSocialMeliRepository.updateDTORepository(userDTOtoLoad);
        }
        return "UserDTO database creada";
    }

    @Override
    public String followById(Integer userId, Integer userIdToFollow) throws UserNotFoundException, RepositoryUnableException {
        if(!iSocialMeliRepository.tableInRepositoryStatus(USERDTO_TABLE)) throw new RepositoryUnableException();
        UserDTO userDTOtoFollow = getUserDTOByIdService(userIdToFollow);
        UserDTO userDTOFollower = getUserDTOByIdService(userId);

        userDTOtoFollow.addFollower(iSocialMeliRepository.getUserById(userId));
        userDTOFollower.addFollowed(iSocialMeliRepository.getUserById(userIdToFollow));

        iSocialMeliRepository.updateDTORepository(userDTOtoFollow);
        iSocialMeliRepository.updateDTORepository(userDTOFollower);

        return ("el usuario " + iSocialMeliRepository.getUserById(userId).getName() + " ahora sigue a " + userDTOtoFollow.getName());
    }


    @Override
    public String unfollowById(Integer userId, Integer userIdToUnFollow) throws UserNotFoundException, RepositoryUnableException, RemoveFollowerException, RemoveFollowedException {
        if(!iSocialMeliRepository.tableInRepositoryStatus(USERDTO_TABLE)) throw new RepositoryUnableException();
        UserDTO userDTOtoUnfollow = getUserDTOByIdService(userIdToUnFollow); // usuario seguido
        UserDTO userDTOFollower = getUserDTOByIdService(userId);   // usuario seguidor

        if(!userDTOFollower.removeFollowed(iSocialMeliRepository.getUserById(userIdToUnFollow))) throw new RemoveFollowerException(userDTOtoUnfollow.getName());
        if(!userDTOtoUnfollow.removeFollower(iSocialMeliRepository.getUserById(userId))) throw new RemoveFollowedException(userDTOFollower.getName());

        iSocialMeliRepository.updateDTORepository(userDTOFollower);
        iSocialMeliRepository.updateDTORepository(userDTOtoUnfollow);

        return ("el usuario " + userDTOFollower.getName() + " ahora dejo de seguir a " + userDTOtoUnfollow.getName());
    }


    private UserDTO getUserDTOByIdService(Integer userDTOId) throws UserNotFoundException{
        UserDTO userDTOtoFollow = iSocialMeliRepository.getDTOById(userDTOId, USERDTO_TABLE);
        if(userDTOtoFollow == null) throw new UserNotFoundException();
        return userDTOtoFollow;
    }

    @Override
    public UserFollowersCountDTO followersCount(Integer userId) throws  RepositoryUnableException, UserNotFoundException{
        if(!iSocialMeliRepository.tableInRepositoryStatus(USERDTO_TABLE)) throw new RepositoryUnableException();
        UserDTO userDTO = getUserDTOByIdService(userId);
        return UserDTOMapper.toUserFollowersCountDTO(userDTO, userId);
    }

    @Override
    public UserFollowersDTO followersList(Integer userId) throws  RepositoryUnableException, UserNotFoundException{
        if(!iSocialMeliRepository.tableInRepositoryStatus(USERDTO_TABLE)) throw new RepositoryUnableException();
        UserDTO userDTO = getUserDTOByIdService(userId);
        return UserDTOMapper.toUserFollowersDTO(userDTO, userId);
    }

    @Override
    public UserFollowedDTO followedList(Integer userId) throws  RepositoryUnableException, UserNotFoundException{
        if(!iSocialMeliRepository.tableInRepositoryStatus(USERDTO_TABLE)) throw new RepositoryUnableException();
        UserDTO userDTO = getUserDTOByIdService(userId);
        return UserDTOMapper.toUserFollowedListDTO(userDTO, userId);
    }
}

