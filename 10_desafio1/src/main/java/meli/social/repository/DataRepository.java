package meli.social.repository;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.model.UserModel;

import java.util.Hashtable;
import java.util.List;

public interface DataRepository {

    // --------------------------- USUARIOS ---------------------------
    List<UserModel> getUsersDb ();
    UserModel findUserById(int userId) throws UserIdNotFoundException;
    void saveUserDb (UserModel user, UserModel userToFollow);

    // --------------------------- POSTS ---------------------------
    List<PostModel> getPostsDb();
    PostModel findPostById(int postId);
    void savePostDb (PostModel post);
}
