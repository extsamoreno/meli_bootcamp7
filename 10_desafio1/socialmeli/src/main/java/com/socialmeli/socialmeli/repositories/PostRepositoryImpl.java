package com.socialmeli.socialmeli.repositories;
import com.socialmeli.socialmeli.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PostRepositoryImpl implements PostRepository {

    HashMap<Integer, Post> posts = new HashMap<>();

    @Override
    public void insertPost(Post post){
        posts.put(post.getId_post(),post);
    }

}
