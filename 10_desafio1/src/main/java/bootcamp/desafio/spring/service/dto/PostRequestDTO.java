package bootcamp.desafio.spring.service.dto;

import bootcamp.desafio.spring.model.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostRequestDTO {

    private Long userId;
    private Long id_post;
    private String date;
    private Detail detail;
    private int category;
    private double price;
}
