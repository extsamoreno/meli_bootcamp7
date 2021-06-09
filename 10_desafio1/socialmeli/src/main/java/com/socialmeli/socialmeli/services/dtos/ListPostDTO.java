package com.socialmeli.socialmeli.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ListPostDTO {
    int userId;
    List<PostDTO> posts;
}
