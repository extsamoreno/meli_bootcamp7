package com.meli.desafio1.web.repository;

import com.meli.desafio1.web.dto.PromoPostDTO;
import com.meli.desafio1.web.model.Npost;

import java.util.List;

public interface IPostRepository {
    public List<Npost> getPostList();
    public void setPostList(Npost npost);
    public Npost getPostById(int postId);
    public List<Npost> getPromoPostByUserId(int userId);
}
