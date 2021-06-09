package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.dto.UserDTO;

import java.util.List;

public interface IPostService {
    public List<PostDTO> followedPostByUserId(int userId, String order);
    public void createPost(PostDTO postDTO);
    public List<PostDTO> orderPost(List<PostDTO> postDTO, String order);

}
