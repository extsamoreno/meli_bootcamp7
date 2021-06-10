package bootcamp.desafio.spring.service;

import bootcamp.desafio.spring.exception.UserNotFoundException;
import bootcamp.desafio.spring.model.Follow;
import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.repository.IClientRepository;
import bootcamp.desafio.spring.repository.IFollowRepository;
import bootcamp.desafio.spring.service.dto.UserCountFollowersDTO;
import bootcamp.desafio.spring.service.dto.UserDTO;
import bootcamp.desafio.spring.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    IClientRepository iClientRepository;

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public void follow(Long userId, Long sellerId) throws UserNotFoundException{
        if(!iClientRepository.findById(userId).isPresent()){
            throw new UserNotFoundException(userId);
        }
        if(!iClientRepository.findById(sellerId).isPresent()){
            throw new UserNotFoundException(sellerId);
        }
        Follow follow= new Follow(userId,sellerId);

        iFollowRepository.save(follow);
    }

    @Override
    public UserCountFollowersDTO countFollowers(Long userId) throws UserNotFoundException {
        Optional<User> user = iClientRepository.findById(userId);
        if(user.isPresent()){
            return new UserCountFollowersDTO(user.get().getUserId(),user.get().getUserName(),iFollowRepository.findByIdFollower(userId).size());
        }
        throw new UserNotFoundException(userId);
    }

    @Override
    public ArrayList<UserDTO> getFollowers(Long userId, String order) {
        ArrayList<UserDTO> result= new ArrayList<>();
        for (Follow us:iFollowRepository.findByIdFollower(userId)) {
            Optional<User> user= iClientRepository.findById(us.getIdUserFollowing());
            if(user.isPresent()){
                result.add(UserMapper.toDTO(user.get()));
            }

        }
        switch (order){
            case "name_asc":
                result.sort((d1,d2) -> d1.getUserName().toLowerCase(Locale.ROOT).compareTo(d2.getUserName().toLowerCase(Locale.ROOT)));
                return result;
            case "name_desc":
                result.sort((d1,d2) -> d2.getUserName().toLowerCase(Locale.ROOT).compareTo(d1.getUserName().toLowerCase(Locale.ROOT)));
                return result;
            default:
                return result;
        }
    }

    @Override
    public ArrayList<UserDTO> getFollows(Long userId, String order) {
        ArrayList<UserDTO> result= new ArrayList<>();
        for (Follow us:iFollowRepository.findByIdFollowing(userId)) {
            Optional<User> user= iClientRepository.findById(us.getIdUserFollower());
            if(user.isPresent()){
                result.add(UserMapper.toDTO(user.get()));
            }
        }
        switch (order){
            case "name_asc":
                result.sort((d1,d2) -> d1.getUserName().toLowerCase(Locale.ROOT).compareTo(d2.getUserName().toLowerCase(Locale.ROOT)));
                return result;
            case "name_desc":
                result.sort((d1,d2) -> d2.getUserName().toLowerCase(Locale.ROOT).compareTo(d1.getUserName().toLowerCase(Locale.ROOT)));
                return result;
            default:
                return result;
        }
    }

    @Override
    public void unfollow(Long userId, Long sellerId) {
        iFollowRepository.remove(new Follow(userId,sellerId));
    }

    @Override
    public ArrayList<User> findAll() {
        return (ArrayList<User>) iClientRepository.findAll();
    }


}
