package com.reto1.demo.Model.DTO.PostObjects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reto1.demo.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date date;
    Product detail;
    int category;
    double price;
}
