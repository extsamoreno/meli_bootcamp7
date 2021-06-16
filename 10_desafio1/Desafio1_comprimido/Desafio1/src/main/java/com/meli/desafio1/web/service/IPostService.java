package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.PostDTO;
import com.meli.desafio1.web.dto.PromoPostDTO;
import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.exception.PostException;
import com.meli.desafio1.web.exception.PostUserNotFoundException;
import com.meli.desafio1.web.exception.UserNotFoundException;
import com.meli.desafio1.web.response.CountPromoPostResponse;
import com.meli.desafio1.web.response.PostListResponse;
import com.meli.desafio1.web.response.PostResponse;
import com.meli.desafio1.web.response.PromoPostListResponse;

import java.util.List;

public interface IPostService {
    public PostListResponse followedPostByUserId(int userId, String order) throws PostException;
    public void createPost(PostDTO postDTO) throws Exception;
    public List<PostResponse> orderPost(List<PostResponse> postResponses, String order);
    public void createPromoPost(PromoPostDTO promoPostDTO) throws Exception;
    public CountPromoPostResponse countPromo(int userId) throws UserNotFoundException;
    PromoPostListResponse listPromo(int userId) throws UserNotFoundException;

}
