package desafio1.demo.Model.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PromoListDTO {
    int userId;
    String userName;
    List<PostResponseDTO> posts;

    public PromoListDTO(int userId, String userName, List<PostResponseDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }
}
