package com.desafiospring.socialMeli.dto.response;

import java.util.List;

import com.desafiospring.socialMeli.dto.PostDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PromoPostListDTO {

    private int userId;
    private String userName;
    private List<PostDTO> posts;

}
