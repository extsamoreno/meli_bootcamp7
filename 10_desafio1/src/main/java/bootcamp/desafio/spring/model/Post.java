package bootcamp.desafio.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    private Long userId;
    private Long idPost;
    private Date date;
    private Detail detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}

