package meli.social.repository;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.UserModel;

import java.util.List;

public interface UserRepository {
    List<UserModel> seedDb ();
    UserModel findUserById(int userId) throws UserIdNotFoundException;
    void saveChangesDb (UserModel user, UserModel userToFollow);
}
