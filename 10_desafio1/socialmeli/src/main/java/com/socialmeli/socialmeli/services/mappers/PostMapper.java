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
                postDTO.getDetails(),
                postDTO.getCategory(),
                postDTO.getPrice()
        );
    }
}
