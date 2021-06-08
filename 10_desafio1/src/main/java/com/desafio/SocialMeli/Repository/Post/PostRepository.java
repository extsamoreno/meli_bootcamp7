package com.desafio.SocialMeli.Repository.Post;

import com.desafio.SocialMeli.Classes.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{

    List<Post> postList = new ArrayList<>();

    @Override
    public List<Post> getAllPosts() {
        return postList;
    }

    @Override
    public Post getPostById(int id_post) {
        return postList.stream().filter(post -> post.getId_post() == id_post).findFirst().orElse(null);
    }

    @Override
    public void savePost(Post post) {
        postList.add(post);
    }

    @Override
    public List<Post> getPostByUserId(int userId) {
        return postList.stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
    }
}
