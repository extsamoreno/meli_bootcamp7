package meli.social.repository;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.UserModel;

import java.util.List;

public interface UserRepository {
    List<UserModel> seedUsers ();
    UserModel findUserById(int userId) throws UserIdNotFoundException;
}
