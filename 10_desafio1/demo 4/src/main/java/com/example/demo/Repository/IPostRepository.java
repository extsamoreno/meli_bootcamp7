package com.example.demo.Repository;

import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Services.DTO.PostDTO;

import java.util.List;

public interface IPostRepository {

    public List<Post> loadPost();
    public void savePosts();
    public boolean postExists(Post newPost);
    public void addPost(Post post);
    public List<PostDTO> getPostOfLasWeek(List<User> seller, String order);

}
