package meli.springchallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FollowedPostDTO {

    private int userId;
    private List<PostDTO> posts;

}
