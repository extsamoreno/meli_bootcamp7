package com.example.demo.repositories;

import com.example.demo.DTO.PostPromoDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.DTO.PostDTO;
import com.example.demo.exceptions.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface IPostRepository {

    public List<Post> loadPost() throws IOException;

    public void savePosts() throws IOException;

    public boolean postExists(Post newPost);

    public void addPost(Post post) throws IOException;

    public List<Post> getPostOfLasWeek(List<User> seller) throws NotFoundException;

    public int getCountPromosByUser(int userId) throws NotFoundException;

    public List<Post> getListPromosByUser(int userId) throws NotFoundException;


}
