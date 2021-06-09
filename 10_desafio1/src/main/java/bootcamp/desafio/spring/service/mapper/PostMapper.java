package bootcamp.desafio.spring.service.mapper;

import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.service.dto.PostDTO;


import java.util.ArrayList;

public class PostMapper {

    public static PostDTO toDTO(Post post){
        return new PostDTO(post.getIdPost(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }

    public static Post toPost(PostDTO post, Long userId){
        return new Post(userId,post.getIdPost(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
    }
}
