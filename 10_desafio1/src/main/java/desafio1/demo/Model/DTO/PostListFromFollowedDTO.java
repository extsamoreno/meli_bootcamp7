package desafio1.demo.Model.DTO;

import desafio1.demo.Model.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListFromFollowedDTO {
    int userId;
    List<NewPostDTO> posts;
}
