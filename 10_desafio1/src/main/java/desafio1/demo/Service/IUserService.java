package desafio1.demo.Service;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.FollowedListDTO;
import desafio1.demo.Model.DTO.FollowersCountDTO;
import desafio1.demo.Model.DTO.FollowersListDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IUserService {
    public void followUser(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException;
    public FollowersCountDTO getFollowersCountById(int userId) throws UserNotFoundException;
    public FollowersListDTO getFollowersListByID(int userId) throws UserNotFoundException;
    public FollowedListDTO getFollowedListByID(int userId) throws UserNotFoundException;
}
