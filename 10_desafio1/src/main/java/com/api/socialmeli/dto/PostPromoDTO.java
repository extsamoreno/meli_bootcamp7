package com.api.socialmeli.dto;

import com.api.socialmeli.model.ProductModel;
import lombok.*;

import java.util.ArrayList;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PostPromoDTO {
    private int userId;
    private String userName;
    private ArrayList<PostNoUserIdDTO> posts;
}
