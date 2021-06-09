package bootcamp.desafio.spring.service.dto;

import bootcamp.desafio.spring.model.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDTO{

    private Long idPost;
    private Date date;
    private Detail detail;
    private int category;
    private double price;


}
