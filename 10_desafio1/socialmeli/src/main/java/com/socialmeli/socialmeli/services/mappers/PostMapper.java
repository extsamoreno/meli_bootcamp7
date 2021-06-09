package com.socialmeli.socialmeli.services.mappers;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class PostMapper {

    public static Post getPost(PostDTO postDTO){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd--MM--yyyy");

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
