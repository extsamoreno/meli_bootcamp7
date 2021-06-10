package meli.social.service.mapper;

import meli.social.model.PostModel;
import meli.social.service.dto.PostDTO;

public class PostMapper {
    public static PostDTO toPostDTO (PostModel post) {
        return new PostDTO(post.getPostId(), post.getDate(),
                post.getDetail(), post.getCategory(), post.getPrice());
    }
 }
