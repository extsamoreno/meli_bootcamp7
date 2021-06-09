package bootcamp.desafio.spring.service.mapper;

import bootcamp.desafio.spring.exception.DateException;
import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.service.dto.PostRequestDTO;
import bootcamp.desafio.spring.util.Utils;

import java.util.ArrayList;

public class PostRequestMapper {

    public static PostRequestDTO toDTO(Post post){
        return new PostRequestDTO(post.getUserId(), post.getIdPost(), post.getDate().toString(), post.getDetail(), post.getCategory(), post.getPrice());
    }

    public static Post toPost(PostRequestDTO post) throws DateException {
        return new Post(post.getUserId(), post.getId_post(), Utils.ParseFecha(post.getDate()), post.getDetail(), post.getCategory(), post.getPrice());
    }

}
