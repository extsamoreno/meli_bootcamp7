package socialmeli.socialmeli.project.repository;

import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.User;

import java.util.ArrayList;

public interface IUserRepository {
    public void loadDataBase();
    public void instanceMapUsersFollowers();
    public ArrayList<User> getUserFollowersList (Integer userId) throws IdNotFoundException;
    public ArrayList<User> getUserFollowedList(Integer userId) throws IdNotFoundException;
    public User findUserById (Integer userId) throws IdNotFoundException;


}
