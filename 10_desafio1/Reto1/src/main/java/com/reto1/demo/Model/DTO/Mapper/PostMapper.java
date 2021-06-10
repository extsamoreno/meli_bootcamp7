package com.reto1.demo.Model.DTO.Mapper;

import com.reto1.demo.Model.DTO.PostObjects.*;
import com.reto1.demo.Model.DTO.UserObjets.UserPromoPostListDTO;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.PromoPost;
import com.reto1.demo.Model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {


    public static LastPostDTO toLastPostDTO(User user, ArrayList<Post> recentPost) {
        List<PostDTO> recentPostDTO = recentPost.stream()
                .map(post -> post instanceof PromoPost ? toPromoPostDTO((PromoPost) post)
                                : toPostDTO(post))
                .collect(Collectors.toList());
        return new LastPostDTO(user.getId(), recentPostDTO);
    }

    private static PostDTO toPromoPostDTO(PromoPost post) {
        return new PromoPostDTO(post.getId_post(), post.getDate(), post.getDetail(),
                post.getCategory(), post.getPrice(), post.isHasPromo(),post.getDiscount());
    }

    public static PostDTO toPostDTO(Post post){
        return new PostDTO(post.getId_post(), post.getDate(), post.getDetail(),
                post.getCategory(), post.getPrice());
    }

    public static PromoPostCount toPromoPostCountMapper(User user) {
        //Count postpromo
        int promoPostcount = (int) user.getPosts().stream().filter(post -> post instanceof PromoPost).count();
        return new PromoPostCount(user.getId(), user.getName(),promoPostcount);
    }


    public static UserPromoPostListDTO toPromoPostDTO(User user) {
        List promopost = Collections.singletonList(user.getPosts().stream().filter(post -> post instanceof PromoPost));
        return new UserPromoPostListDTO(user.getId(), user.getName(), promopost);
    }
}
