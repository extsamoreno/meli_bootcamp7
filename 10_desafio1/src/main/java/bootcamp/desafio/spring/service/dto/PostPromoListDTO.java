package bootcamp.desafio.spring.service.dto;

import bootcamp.desafio.spring.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostPromoListDTO {

    private Long userId;
    private String userName;
    private ArrayList<PostPromoDTO> posts;
}
