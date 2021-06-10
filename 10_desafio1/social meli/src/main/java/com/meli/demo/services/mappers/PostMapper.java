package com.meli.demo.services.mappers;

import com.meli.demo.dtos.PostDTO;
import com.meli.demo.dtos.PostResponseDTO;
import com.meli.demo.models.Post;

public class PostMapper {

    public static PostDTO toDTO(Post post){

        return new PostDTO(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    public static Post toPost(PostDTO post){
        return new Post(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    public static Post toPostDiscount(PostDTO post){
        return new Post(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }
    public static PostResponseDTO toPostResponse(PostDTO post){
        return new PostResponseDTO(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice());
    }

    public static Post ResponsetoDTOPost(PostResponseDTO post){

        return new Post(post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice());
    }


}



