package bootcamp.desafio.spring.service.mapper;

import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.service.dto.PostPromoDTO;

public class PostPromoMapper {

    public static PostPromoDTO toDTO(Post post){
        return new PostPromoDTO(post.getIdPost(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice(),post.isHasPromo(),post.getDiscount());
    }

    public static Post toPost(PostPromoDTO post, Long userId){
        return new Post(userId,post.getIdPost(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice(), post.getHasPromo(), post.getDiscount());
    }
}
