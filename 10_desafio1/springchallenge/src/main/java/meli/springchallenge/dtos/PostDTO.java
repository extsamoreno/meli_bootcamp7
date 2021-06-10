package meli.springchallenge.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private int userId;
    private int postId;
    @JsonFormat(pattern="dd-MM-yyyy", timezone="UTC")
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
