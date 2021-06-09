package desafio1.demo.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListFromFollowedDTO {
    int userId;
    List<PostResponseDTO> posts;
}
