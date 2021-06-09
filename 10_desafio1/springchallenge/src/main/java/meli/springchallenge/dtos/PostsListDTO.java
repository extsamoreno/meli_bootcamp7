package meli.springchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsListDTO {

    private int userId;
    private String userName;
    private List<PostDTO> posts;
}
