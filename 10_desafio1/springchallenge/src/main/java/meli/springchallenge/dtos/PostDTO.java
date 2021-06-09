package meli.springchallenge.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private int userId;
    private int id_post;
    private String date;
//    @JsonFormat(pattern="dd-MM-yyyy", timezone = "")
//    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;

}
