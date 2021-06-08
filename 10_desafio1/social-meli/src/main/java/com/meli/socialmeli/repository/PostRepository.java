package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void insertPost(Post post) {
        this.posts.add(post);
        System.out.println(this.posts.get(0));
    }
}
