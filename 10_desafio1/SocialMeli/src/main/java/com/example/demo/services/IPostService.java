package com.example.demo.services;

import com.example.demo.DTO.ResponseCountPromosDTO;
import com.example.demo.DTO.ResponseGetPostsFollowedDTO;
import com.example.demo.DTO.ResponseListPromosDTO;
import com.example.demo.entities.Post;
import com.example.demo.exceptions.NotFoundException;

public interface IPostService {

    public ResponseListPromosDTO listPromosByUser(int userId) throws NotFoundException;
    public ResponseCountPromosDTO promosByUser(int userId) throws NotFoundException;
    public ResponseGetPostsFollowedDTO getPostsFollowed(int userId, String order) throws Exception;
    public void addPost(Post post) throws Exception;
}
