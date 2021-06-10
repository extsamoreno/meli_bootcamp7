package meli.social.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class PostModel {
    private int userId, postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private ProductModel detail;
    private int category;
    private double price;
}
