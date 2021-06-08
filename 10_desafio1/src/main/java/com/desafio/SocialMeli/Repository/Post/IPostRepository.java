package com.desafio.SocialMeli.Repository.Post;

import com.desafio.SocialMeli.Classes.Post;

import java.util.List;

public interface IPostRepository {
    
    List<Post> getAllPosts();

    Post getPostById(int id_post);

    void savePost (Post post);

    List<Post> getPostByUserId(int userId);
}
