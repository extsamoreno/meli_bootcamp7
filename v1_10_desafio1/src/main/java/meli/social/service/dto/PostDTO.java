package meli.social.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import meli.social.model.ProductModel;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class PostDTO {
    private int postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private ProductModel detail;
    private int category;
    private double price;
}

