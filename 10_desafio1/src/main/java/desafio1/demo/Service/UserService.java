package desafio1.demo.Service;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Repository.IRepository;
import org.springframework.stereotype.Repository;
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


}
