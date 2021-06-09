package com.socialmeli.socialmeli.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    int userId;
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    Product detail;
    int category;
    double price;
}
