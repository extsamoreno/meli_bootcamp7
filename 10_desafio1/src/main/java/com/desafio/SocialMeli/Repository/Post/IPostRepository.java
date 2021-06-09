package com.desafio.SocialMeli.Repository.Post;

import com.desafio.SocialMeli.Classes.Post;
import com.desafio.SocialMeli.DTO.Post.PromoPostDTO;

import java.util.List;

public interface IPostRepository {
    
    List<Post> getAllPosts();

    Post getPostById(int id_post);

    void savePost (Post post);

    List<Post> getPostByUserId(int userId, int ageInDays);

    List<PromoPostDTO> getPromoPostsByUserId(int userId);

}
