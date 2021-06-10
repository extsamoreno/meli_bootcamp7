package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.*;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.repositories.IUserRepository;
import com.example.DesafioSpring.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service

public class UserServiceImple extends OrderByService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;


    //Agrega seguidores
    private void addFollower(User user, int followerId){
        List<Integer> followers = user.getFollowers();
        if(followers.indexOf(followerId) == -1 && user.getId() != followerId){
            followers.add(followerId);
        }
    }

    //Agrega seguidos
    private void followedBy(User user, int followedId){
        List<Integer> followedBy = user.getFollowing();

        if(followedBy.indexOf(followedId) == -1 && user.getId() != followedId){
            followedBy.add(followedId);
        }

    }

    //Elimina seguidos
    private void removeFollowedBy(User user, int followedId){
        List<Integer> followedBy = user.getFollowing();

        int index = followedBy.indexOf(followedId);
        if(index != -1 && user.getId() != followedId){
            followedBy.remove(index);
        }

    }

    //Lista de seguidos por y ordenados
    @Override
    public FollowedByDTO bringFollowedBy(int userId, String order) throws UserNotFoundException{

        User user = iUserRepository.getUserByID(userId);
        List<User> followed = iUserRepository.getUsersByIds(user.getFollowing());

        List<UserDTO> userDTOs = UserMapper.toDTOs(followed);
        Comparator<UserDTO> comparator = this.compare(order);
        this.bubbleSort(userDTOs, comparator);

        return new FollowedByDTO(user.getId(), user.getName(), userDTOs);
    }
    private void removeFollowerToUser(User user, int followerId) {

        List<Integer> followers = user.getFollowers();

        int index = followers.indexOf(followerId);
        if(index != -1 && user.getId() != followerId){
            followers.remove(index);
        }

    }
    //Cantidad de seguidores
    @Override
    public FollowersCountDTO getFollowersCount(int userId) throws UserNotFoundException {

        User user = iUserRepository.getUserByID(userId);

        return new FollowersCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }

//Lista de seguidores ordenados
    @Override
    public FollowersDTO getFollowers(int userId, String order) throws UserNotFoundException {

        User user = iUserRepository.getUserByID(userId);
        List<User> follower = iUserRepository.getUsersByIds(user.getFollowers());
        List<UserDTO> userDTOs = UserMapper.toDTOs(follower);

        this.bubbleSort(userDTOs, this.compare(order));

        return new FollowersDTO(user.getId(), user.getName(), userDTOs);
    }


//Seguir a un vendedor
    @Override
    public FollowDTO followSeller(int followerId, int followedId) throws UserNotFoundException {

        User follower = iUserRepository.getUserByID(followerId);
        User followed = iUserRepository.getUserByID(followedId);

        this.addFollower(followed, followerId);
        this.followedBy(follower, followedId);

        return new FollowDTO(follower.getId(),followed.getId(), "Follow");
    }

    //Dejar de seguir a un vendedor
    @Override
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException {
        User follower = iUserRepository.getUserByID(followerId);
        User followed = iUserRepository.getUserByID(followedId);

        this.removeFollowerToUser(followed, followerId);
        this.removeFollowedBy(follower, followedId);

        return new FollowDTO(follower.getId(),followed.getId(), "Unfollow");
    }

    //Metodo que ordena por nombre o ID y por tipo ascendente o descendente
    private Comparator<UserDTO> compare(String order){
        Comparator<UserDTO> comparator;

        String orderBy = this.orderBy(order);
        String type = this.orderType(order);

        switch (orderBy){
            case "name": comparator = Comparator.comparing(UserDTO::getUserName);
            case "id": comparator = Comparator.comparing(UserDTO::getUserId);
            default: comparator = Comparator.comparing(UserDTO::getUserName);
        }
        switch (type){
            case "desc" : comparator = comparator.reversed();
        }

        return comparator;
    }


}
