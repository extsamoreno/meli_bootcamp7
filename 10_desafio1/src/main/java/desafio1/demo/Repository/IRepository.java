package desafio1.demo.Repository;

import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.Entity.User;

import java.util.HashMap;

public interface IRepository {
    public HashMap<Integer, User> getUserDict();
    public User getUserById(int id) throws UserNotFoundException;
}
