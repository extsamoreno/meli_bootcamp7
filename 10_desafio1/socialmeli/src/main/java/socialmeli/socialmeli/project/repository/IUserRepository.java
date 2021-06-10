package socialmeli.socialmeli.project.repository;

import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IUserRepository {

    ArrayList<User> getUserFollowersList (Integer userId) throws IdNotFoundException;
     ArrayList<User> getUserFollowedList(Integer userId) throws IdNotFoundException;
     User findUserById (Integer userId) throws IdNotFoundException;
}
