package com.socialmeli.socialmeli.services.mappers;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostMapper {

    public static Post getPost(PostDTO postDTO){

        return new Post(
                postDTO.getUserId(),
                postDTO.getId_post(),
                postDTO.getDate(),
                postDTO.getDetail(),
                postDTO.getCategory(),
                postDTO.getPrice()
        );
    }

    public static PostDTO getPostDTO(Post post){

        return new PostDTO(
                post.getUserId(),
                post.getId_post(),
                post.getDate(),
                post.getDetail(),
                post.getCategory(),
                post.getPrice()
        );
    }


}
