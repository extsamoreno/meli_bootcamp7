package com.example.demo.repositories;

import com.example.demo.DTO.PostPromoDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.DTO.PostDTO;

import java.util.List;

public interface IPostRepository {

    public List<Post> loadPost();

    public void savePosts();

    public boolean postExists(Post newPost);

    public void addPost(Post post);

    public List<PostDTO> getPostOfLasWeek(List<User> seller, String order);

    public int getCountPromosByUser(int userId);

    public List<PostPromoDTO> getListPromosByUser(int userId);


}
