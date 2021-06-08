package com.meli.socialmeli.model.dao.repository;

import com.meli.socialmeli.database.DataBasePost;
import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepositoryPostImpl implements RepositoryPost {

    @Autowired
    private RepositoryUsers repositoryUsers;

    private ArrayList<Post> dataBasePost = DataBasePost.dataBasePost;

    public Post getPostById(int postId) {
        ArrayList<Post> postList = dataBasePost;
        Post postReturn = null;
        for (Post post: postList) {
            if(post.getIdPost() == postId) {
                postReturn = post;
            }
        }
        return postReturn;
    }

    public boolean createNewPost(Post post) {
        User user = repositoryUsers.getUserById(post.getUserId());
        if (user == null) {
            return false;
        }
        if (getPostById(post.getIdPost()) != null) {
            return false;
        }
        dataBasePost.add(post);
        user.getPost().add(post.getIdPost());
        return true;
    }
}
