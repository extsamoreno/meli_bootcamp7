package desafio1.demo.Service;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserDoesNotFollowException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Helper.HelperComparator;
import desafio1.demo.Model.DTO.FollowedListDTO;
import desafio1.demo.Model.DTO.FollowersCountDTO;
import desafio1.demo.Model.DTO.FollowersListDTO;
import desafio1.demo.Model.DTO.UserDTO;
import desafio1.demo.Repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    IRepository repository;

    public UserService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException {
        if(userId == userIdToFollow){
            throw new UserCantFollowHimselfException(userId);
        }
        var user = repository.getUserById(userId);
        var userToFollow = repository.getUserById(userIdToFollow);
        if (user.getFollowedUsersList().contains(userToFollow)){
            throw new UserAlreadyFollowsException(userId, userIdToFollow);
        }
        user.getFollowedUsersList().add(userToFollow);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException, UserDoesNotFollowException {
        var user = repository.getUserById(userId);
        var userToUnfollow = repository.getUserById(userIdToUnfollow);
        if (!user.getFollowedUsersList().remove(userToUnfollow)){
            throw new UserDoesNotFollowException(userId,userIdToUnfollow);
        }
    }

    @Override
    public FollowersCountDTO getFollowersCountById(int userId) throws UserNotFoundException {
        var user = repository.getUserById(userId);
        var count = this.repository.getUserFollowersById(userId).count();
        return new FollowersCountDTO(userId, user.getUserName(), count);
    }

    @Override
    public FollowersListDTO getFollowersListById(int userId, String order) throws UserNotFoundException {
        var user = repository.getUserById(userId);
        var userDTOArray = this.repository.getUserFollowersById(userId)
                .sorted(HelperComparator.userNameComparator(order))
                .map(u -> new UserDTO(u.getUserId(),u.getUserName()))
                .toArray(UserDTO[]::new);
        return new FollowersListDTO(userId, user.getUserName(), userDTOArray);
    }

    @Override
    public FollowedListDTO getFollowedListById(int userId, String order) throws UserNotFoundException {
        var user = repository.getUserById(userId);
        var userDTOArray = user.getFollowedUsersList().stream()
                .sorted(HelperComparator.userNameComparator(order))
                .map(u->new UserDTO(u.getUserId(),u.getUserName()))
                .toArray(UserDTO[]::new);
        return new FollowedListDTO(userId,user.getUserName(),userDTOArray);
    }


}
