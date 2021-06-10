package com.socialmeli.socialmeli.services.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ListPostPromoDTO {
    int userId;
    String userName;
    List<PostPromoDTO> posts;
}
