package desafio1.desafio1.service.productService.dto;

import desafio1.desafio1.domain.Publications;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PostsDTO {
    private int userId;
    private List<Publications> posts;

    public PostsDTO() {
        this.posts = new ArrayList<>();
    }
}
