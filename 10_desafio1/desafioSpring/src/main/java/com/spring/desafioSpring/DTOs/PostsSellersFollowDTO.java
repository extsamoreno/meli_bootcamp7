package com.spring.desafioSpring.DTOs;

import lombok.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostsSellersFollowDTO {
    private Integer userId;
    List<PostWithoutIdUserDTO> posts;
}
