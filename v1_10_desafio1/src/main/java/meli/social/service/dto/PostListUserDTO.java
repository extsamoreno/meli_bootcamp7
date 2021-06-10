package meli.social.service.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class PostListUserDTO {
    private int userId;
    private List<PostDTO> posts;
}
