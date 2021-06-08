package desafio1.demo.Service;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.FollowersCountDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IUserService {
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException;
    public FollowersCountDTO getFollwersCountById(int userId) throws UserNotFoundException;
}
