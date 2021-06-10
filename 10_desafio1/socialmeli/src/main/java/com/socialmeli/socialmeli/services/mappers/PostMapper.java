package com.socialmeli.socialmeli.services.mappers;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import com.socialmeli.socialmeli.services.dtos.PostPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PostMapper {

    public static Post getPostFromPostDTO(PostDTO postDTO){

        return new Post(
                postDTO.getUserId(),
                postDTO.getId_post(),
                postDTO.getDate(),
                postDTO.getDetail(),
                postDTO.getCategory(),
                postDTO.getPrice(),
                false,
                0
        );
    }

    public static PostDTO getPostDTOFromPost(Post post){

        return new PostDTO(
                post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice()
        );
    }

    public static PostPromoDTO getPostPromoDTOFromPost(Post post){

        return new PostPromoDTO(
                post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public static List<PostPromoDTO> getPostPromoListFromPostList(List<Post> postList){
        List<PostPromoDTO> postPromoDTOList = new ArrayList<>();
        for (Post post: postList
             ) {
            postPromoDTOList.add(
                    getPostPromoDTOFromPost(post)
            );
        }
        return postPromoDTOList;
    }

    public static Post getPostFromPostPromoDTO(PostPromoDTO postPromoDTO){

        return new Post(
                postPromoDTO.getUserId(),
                postPromoDTO.getId_post(),
                postPromoDTO.getDate(),
                postPromoDTO.getDetail(),
                postPromoDTO.getCategory(),
                postPromoDTO.getPrice(),
                postPromoDTO.isHasPromo(),
                postPromoDTO.getDiscount()
        );
    }




}
