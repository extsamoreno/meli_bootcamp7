package com.meli.socialmeli.model.dao.repository;

import com.meli.socialmeli.database.DataBasePost;
import com.meli.socialmeli.database.DataBaseUsers;
import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositoryUsersImpl implements RepositoryUsers{
    private ArrayList<User> dataBaseUsers = DataBaseUsers.dataBaseUsers;
    private ArrayList<Post> dataBasePost = DataBasePost.dataBasePost;

    public User getUserById(int userId) {
        ArrayList<User> userList = dataBaseUsers;
        User userReturn = null;
        for (User user: dataBaseUsers) {
            if(user.getUserId() == userId) {
                userReturn = user;
            }
        }
        return userReturn;
    }

    public Post getPostById(int postId) {
        ArrayList<Post> postList = dataBasePost;
        Post postReturn = null;
        for (Post post: dataBasePost) {
            if(post.getIdPost() == postId) {
                postReturn = post;
            }
        }
        return postReturn;
    }

    public boolean createNewPost(Post post) {
        User user = getUserById(post.getUserId());
        if (user == null) {
            return false;
        }
        if (getPostById(post.getIdPost()) != null) {
            return false;
        }
        dataBasePost.add(post);
        user.getPost().add(post);
        return true;
    }
}
