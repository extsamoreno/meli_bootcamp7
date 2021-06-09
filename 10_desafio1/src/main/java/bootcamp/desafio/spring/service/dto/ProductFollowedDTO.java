package bootcamp.desafio.spring.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductFollowedDTO {

    private long userId;
    private ArrayList<PostDTO> posts;
}
