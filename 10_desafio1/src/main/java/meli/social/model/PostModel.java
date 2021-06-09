package meli.social.model;

import com.fasterxml.jackson.datatype.jsr310.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostModel {
    private int userId, postId;
    private String date;
//    @JsonFormat(pattern="dd-MM-yyyy")
//    private LocalDate date;
    private ProductModel detail;
    private int category;
    private double price;
}
