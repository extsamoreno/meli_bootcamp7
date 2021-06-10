package com.desafio.SocialMeli.Repository.Post;

import com.desafio.SocialMeli.Model.Post;
import com.desafio.SocialMeli.DTO.Post.PromoPostDTO;
import com.desafio.SocialMeli.Mapper.PostMapper;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Post> getPostByUserId(int userId, int ageInDays) {
        Instant now = Instant.now(); //current date
        Instant before = now.minus(Duration.ofDays(ageInDays));
        Date dateBefore = Date.from(before);
        return postList.stream().filter(post -> post.getUserId() == userId && post.getDate().after(dateBefore)).collect(Collectors.toList());
    }

    @Override
    public List<PromoPostDTO> getPromoPostsByUserId(int userId) {
        List<PromoPostDTO> promoPostDTOS = new ArrayList<>();
        List<Post> posts = postList.stream().filter(post -> post.isHasPromo() && post.getUserId() == userId).collect(Collectors.toList());
        for (Post post : posts) {
            promoPostDTOS.add(PostMapper.toPromoPostDTO(post));
        }
        return promoPostDTOS;
    }
}